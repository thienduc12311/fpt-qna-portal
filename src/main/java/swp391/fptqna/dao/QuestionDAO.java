package swp391.fptqna.dao;

import swp391.fptqna.dto.ExtendQuestionList;
import swp391.fptqna.dto.ExtendedQuestionDTO;
import swp391.fptqna.dto.QuestionDTO;
import swp391.fptqna.dto.TagDTO;
import swp391.fptqna.utils.CustomException;
import swp391.fptqna.utils.DButil;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;

public class QuestionDAO {


    private QuestionDTO parseFromDB(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("Id");
        Date creationDate = resultSet.getDate("CreationDate");
        Date closedDate = resultSet.getDate("ClosedDate");
        Date deletionDate = resultSet.getDate("DeletionDate");
        int score = resultSet.getInt("Score");
        String title = resultSet.getString("Title");
        String body = resultSet.getString("Body");
        int ownerUserId = resultSet.getInt("OwnerUserId");
        int approveUserId = resultSet.getInt("ApproveUserId");
        int lastEditorUserId = resultSet.getInt("LastEditorUserId");
        Date lastEditDate = resultSet.getDate("LastEditDate");
        int answerCount = resultSet.getInt("AnswerCount");
        int commentCount = resultSet.getInt("CommentCount");
        return new QuestionDTO(id, creationDate, closedDate, deletionDate, score, title, body, ownerUserId, approveUserId, lastEditorUserId, lastEditDate, answerCount, commentCount);
    }

    public QuestionDTO getQuestionById(int id) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select * from Questions Where Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet != null && resultSet.next()) {
                    return parseFromDB(resultSet);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<QuestionDTO> getAvailableQuestionByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM \n" +
                    "(SELECT * FROM Questions \n" +
                    "    WHERE (ApproveUserId IS NOT NULL AND DeletionDate IS NULL AND ClosedDate IS NULL AND NOT(Title like '%Semester %' and LEN(Title) = 10) )   \n" +
                    "    ORDER BY CreationDate DESC \n" +
                    "    OFFSET ? ROWS \n" +
                    "    FETCH NEXT 10 ROWS ONLY) q \n" +
                    "INNER JOIN Users u ON q.OwnerUserId = u.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    int role = resultSet.getInt("Role");
                    question.setOwnerRole(role);
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getNumberOfAvailablePage() throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Questions WHERE DeletionDate IS NULL AND ClosedDate IS NULL AND ApproveUserId IS NOT NULL AND NOT(Title like '%Semester %' and LEN(Title) = 10)";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ExtendedQuestionDTO getExtendQuestionById(int questionId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "Select  * From (Select * From Questions WHERE ApproveUserId IS NOT NULL and DeletionDate IS NULL AND ClosedDate IS NULL And Id = ?) q INNER JOIN Users u ON q.OwnerUserId = u.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                QuestionDTO question = parseFromDB(resultSet);
                String userName = resultSet.getString("UserDisplayName");
                String avtUrl = resultSet.getString("ImgLink");
                int role = resultSet.getInt("Role");
                question.setOwnerRole(role);
                question.setOwnerName(userName);
                question.setOwnerAvt(avtUrl);
                ExtendedQuestionDTO extendedQuestion = new ExtendedQuestionDTO(question);
                return extendedQuestion;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Filter by Tag
    public int getNumberOfAvailablePageFilterTag(String tag) throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(q.Id) AS numOfQuestions\n" +
                    "FROM Questions q, [dbo].[QuestionTags] qt, [dbo].[Tags] t\n" +
                    "WHERE DeletionDate IS NULL AND ApproveUserId IS NOT NULL AND ClosedDate IS NULL AND NOT(Title like '%Semester %' and LEN(Title) = 10)\n" +
                    "AND q.Id = qt.QuestionId AND qt.TagId = t.Id\n" +
                    "AND t.TagName = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, tag);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public ArrayList<QuestionDTO> getAvailableQuestionFilterTagByPage(int page, String tag) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM (\n" +
                    "SELECT q.*\n" +
                    "FROM Questions q, [dbo].[QuestionTags] qt, [dbo].[Tags] t\n" +
                    "WHERE DeletionDate IS NULL AND ApproveUserId IS NOT NULL AND ClosedDate IS NULL AND NOT(Title like '%Semester %' and LEN(Title) = 10)\n" +
                    "AND q.Id = qt.QuestionId AND qt.TagId = t.Id\n" +
                    "AND t.TagName = ?\n" +
                    "ORDER BY q.CreationDate DESC \n" +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY\n" +
                    ") question\n" +
                    "INNER JOIN Users u ON question.OwnerUserId = u.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, tag);
            preparedStatement.setInt(2, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    int role = resultSet.getInt("Role");
                    question.setOwnerRole(role);
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<QuestionDTO> getAvailableQuestionFilterResourceByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM (\n" +
                    "SELECT q.*\n" +
                    "FROM Questions q, [dbo].[QuestionTags] qt, [dbo].[Tags] t\n" +
                    "WHERE DeletionDate IS NULL AND ApproveUserId IS NOT NULL \n" +
                    "AND q.Id = qt.QuestionId AND qt.TagId = t.Id\n" +
                    "AND t.TagName = ?\n" +
                    "ORDER BY q.CreationDate DESC \n" +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY\n" +
                    ") question\n" +
                    "INNER JOIN Users u ON question.OwnerUserId = u.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, "Resource");
            preparedStatement.setInt(2, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    int role = resultSet.getInt("Role");
                    question.setOwnerRole(role);
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public ArrayList<QuestionDTO> getAvailableQuestionFilterDiscussionByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM (\n" +
                    "SELECT q.*\n" +
                    "FROM Questions q, [dbo].[QuestionTags] qt, [dbo].[Tags] t\n" +
                    "WHERE DeletionDate IS NULL AND ClosedDate IS NULL AND ApproveUserId IS NOT NULL AND NOT(Title like '%Semester %' and LEN(Title) = 10)\n" +
                    "AND q.Id = qt.QuestionId AND qt.TagId = t.Id\n" +
                    "AND t.TagName = 'Discussion' \n" +
                    "ORDER BY q.CreationDate DESC \n" +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY\n" +
                    ") question\n" +
                    "INNER JOIN Users u ON question.OwnerUserId = u.Id WHERE u.Role = 1";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    int role = resultSet.getInt("Role");
                    question.setOwnerRole(role);
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getNumberOfAvailablePageFilterDiscussion() throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(*) AS numOfQuestions FROM (\n" +
                    "SELECT q.*\n" +
                    "FROM Questions q, [dbo].[QuestionTags] qt, [dbo].[Tags] t\n" +
                    "WHERE DeletionDate IS NULL AND ApproveUserId IS NOT NULL AND NOT(Title like '%Semester %' and LEN(Title) = 10)\n" +
                    "AND q.Id = qt.QuestionId AND qt.TagId = t.Id\n" +
                    "AND t.TagName = 'Discussion' \n" +
                    ") question\n" +
                    "INNER JOIN Users u ON question.OwnerUserId = u.Id WHERE u.Role = 1";
            Statement stmt = cn.createStatement();
            try (ResultSet resultSet = stmt.executeQuery(query)) {
                if (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Filter by Most liked
    public ArrayList<QuestionDTO> getAvailableQuestionFilterMostLikedByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM (\n" +
                    "SELECT *\n" +
                    "FROM Questions q\n" +
                    "WHERE DeletionDate IS NULL AND ApproveUserId IS NOT NULL AND ClosedDate IS NULL AND NOT(Title like '%Semester %' and LEN(Title) = 10)\n" +
                    "ORDER BY Score DESC " +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY\n" +
                    ") question\n" +
                    "INNER JOIN Users u ON question.OwnerUserId = u.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    int role = resultSet.getInt("Role");
                    question.setOwnerRole(role);
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Filter by Most Answered
    public ArrayList<QuestionDTO> getAvailableQuestionFilterMostAnsweredByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM (\n" +
                    "SELECT *\n" +
                    "FROM Questions q\n" +
                    "WHERE DeletionDate IS NULL AND ApproveUserId IS NOT NULL AND ClosedDate IS NULL AND NOT(Title like '%Semester %' and LEN(Title) = 10)\n" +
                    "ORDER BY AnswerCount DESC " +
                    "OFFSET ? ROWS\n" +
                    "FETCH NEXT 10 ROWS ONLY\n" +
                    ") question\n" +
                    "INNER JOIN Users u ON question.OwnerUserId = u.Id";
            ;
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    int role = resultSet.getInt("Role");
                    question.setOwnerRole(role);
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getNumberOfAvailablePageFilterUserId(int userId) throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(q.Id) AS numOfQuestions\n" +
                    "FROM Questions q " +
                    "WHERE DeletionDate IS NULL AND ApproveUserId IS NOT NULL AND ClosedDate IS NULL\n" +
                    "AND OwnerUserId = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    //Filter by User Id
    public ArrayList<QuestionDTO> getAvailableQuestionFilterUserIdByPage(int page, int userId) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM \n" +
                    "(SELECT * FROM Questions \n" +
                    "    WHERE (ApproveUserId IS NOT NULL AND DeletionDate IS NULL AND OwnerUserId = ? AND ClosedDate IS NULL)   \n" +
                    "    ORDER BY CreationDate DESC \n" +
                    "    OFFSET ? ROWS \n" +
                    "    FETCH NEXT 10 ROWS ONLY) q \n" +
                    "INNER JOIN Users u ON q.OwnerUserId = u.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    int role = resultSet.getInt("Role");
                    question.setOwnerRole(role);
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //Search: Filter by Keyword
    public ArrayList<QuestionDTO> getAvailableQuestionFilterKeywordByPage(int page, String txtSearch) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM \n" +
                    "(SELECT * FROM Questions \n" +
                    "    WHERE (ApproveUserId IS NOT NULL AND DeletionDate IS NULL AND ClosedDate IS NULL AND Title LIKE ? AND NOT(Title like '%Semester %' and LEN(Title) = 10))   \n" +
                    "    ORDER BY CreationDate DESC \n" +
                    "    OFFSET ? ROWS \n" +
                    "    FETCH NEXT 10 ROWS ONLY) q \n" +
                    "INNER JOIN Users u ON q.OwnerUserId = u.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, "%" + txtSearch + "%");
            preparedStatement.setInt(2, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    QuestionDTO question = parseFromDB(resultSet);
                    String userName = resultSet.getString("UserDisplayName");
                    String avtUrl = resultSet.getString("ImgLink");
                    int role = resultSet.getInt("Role");
                    question.setOwnerRole(role);
                    question.setOwnerName(userName);
                    question.setOwnerAvt(avtUrl);
                    list.add(question);
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int getNumberOfAvailablePageFilterKeyword(String txtSearch) throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT (Id) numOfQuestions FROM Questions WHERE Title LIKE ? AND NOT(Title like '%Semester %' and LEN(Title) = 10)";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, "%" + txtSearch + "%");
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }


    public ExtendQuestionList getAllTagsOfQuestion(ExtendQuestionList questions) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM (SELECT * FROM QuestionTags WHERE QuestionId IN (?,?,?,?,?,?,?,?,?,?)) q INNER JOIN Tags t ON q.TagId = t.Id";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            for (int i = 0; i < questions.size(); i++) {
                preparedStatement.setInt(i + 1, questions.get(i).getId());
            }
            for (int i = questions.size() + 1; i < 11; i++) {
                preparedStatement.setString(i, null);
            }

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int questionId = resultSet.getInt("QuestionId");
                    int id = resultSet.getInt("Id");
                    String tagName = resultSet.getString("TagName");
                    String description = resultSet.getString("Discription");
                    Date creationDate = resultSet.getDate("CreationDate");
                    int ownerUserId = resultSet.getInt("OwnerUserId");
                    int questionCount = resultSet.getInt("QuestionCount");
                    byte state = resultSet.getByte("State");
                    TagDTO tag = new TagDTO(id, tagName, description, creationDate, ownerUserId, questionCount, state);
                    questions.getQuestionById(questionId).getTags().add(tag);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return questions;
    }

    public ArrayList<QuestionDTO> getPendingQuestionByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Questions \n" + "WHERE ApproveUserId IS NULL AND DeletionDate IS NULL \n" + "ORDER BY CreationDate ASC \n" + "OFFSET ? ROWS\n" + "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(parseFromDB(resultSet));
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean approve(int questionId, int userId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE Questions SET ApproveUserId = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, questionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean delete(int questionId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "DELETE FROM Questions WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteWithoutDB(int questionId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE Questions SET DeletionDate = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(2, questionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean undelete(int questionId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE Questions SET DeletionDate = NULL WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, questionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean closeQuestion(int questionId) {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "UPDATE Questions SET ClosedDate = ? WHERE Id = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setTimestamp(1, new Timestamp(new Date().getTime()));
            preparedStatement.setInt(2, questionId);
            int rs = preparedStatement.executeUpdate();
            return rs > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }


    public ArrayList<QuestionDTO> getQuestionByPage(int page) throws Exception {
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT * FROM Questions \n" + "ORDER BY Id ASC \n" + "OFFSET ? ROWS\n" + "FETCH NEXT 10 ROWS ONLY;";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, 10 * (page - 1));
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                ArrayList<QuestionDTO> list = new ArrayList<>();
                while (resultSet.next()) {
                    list.add(parseFromDB(resultSet));
                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean createNewQuestion(int userId, String questionTilte, String questionBody, String[] tags, Timestamp createdDate) {

        String createQuestion = "INSERT INTO Questions(OwnerUserId, Title, Body, CreationDate) OUTPUT INSERTED.Id  VALUES (?,?,?,?)";
        String createQuestionTag = "INSERT INTO QuestionTags(QuestionId, TagId) VALUES (?,?)";
        try (Connection con = DButil.getMyConnection()) {
            boolean success = false;
            try (
                    PreparedStatement questionStm = con.prepareStatement(createQuestion);
                    PreparedStatement questionTagStm = con.prepareStatement(createQuestionTag)) {
                con.setAutoCommit(false);

                int questionId = 0;
                questionStm.setInt(1, userId);
                questionStm.setString(2, questionTilte);
                questionStm.setString(3, questionBody);
                questionStm.setTimestamp(4, createdDate);
                try (ResultSet rs = questionStm.executeQuery();) {
                    if (rs.next()) {
                        questionId = rs.getInt("Id");
                        success = true;
                    }
                }


                if (success) {
                    questionTagStm.setInt(1, questionId);
                    for (String tagId : tags) {
                        questionTagStm.setInt(2, Integer.parseInt(tagId));
                        questionTagStm.addBatch();
                    }
                    int[] questionTagResult = questionTagStm.executeBatch();

                    for (int r : questionTagResult) {
                        if (r == 0) {
                            success = false;
                        }
                    }
                }

                if (success) {
                    con.commit();
                    return true;
                } else {
                    throw new CustomException("Something went wrong, please try again later");
                }

            }
        } catch (Exception ex) {
            System.out.println(ex);
        }

        return false;
    }

    public int getNumberOfPagePendingQuestion() throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Questions WHERE ApproveUserId IS NULL AND DeletionDate IS NULL  ";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfRecord;
    }

    public int getNumberOfPage() throws Exception {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Questions";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfRecord;
    }

    public boolean updateQuestion(int userId, int questionId, String description, String title) {
        String query = "UPDATE Questions SET Body = ?, Title = ? WHERE OwnerUserId = ? AND Id = ?";
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setString(1, description);
            preparedStatement.setString(2, title);
            preparedStatement.setInt(4, questionId);
            preparedStatement.setInt(3, userId);
            int result = preparedStatement.executeUpdate();
            return result > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public ArrayList<QuestionDTO> getAllQuestionOfUser(int userId, int page) {
        String query = "SELECT * FROM Questions WHERE OwnerUserId = ? AND ClosedDate IS NULL " + "ORDER BY CreationDate DESC \n" + "OFFSET ? ROWS\n" + "FETCH NEXT 10 ROWS ONLY;";
        ArrayList<QuestionDTO> questionDTOS = new ArrayList<>();
        try (Connection cn = DButil.getMyConnection()) {
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, 10 * (page - 1));
            ResultSet result = preparedStatement.executeQuery();
            while (result.next()) {
                QuestionDTO questionDTO = parseFromDB(result);
                questionDTOS.add(questionDTO);
            }
            return questionDTOS;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int numberOfQuestionByUser(int userId) {
        int numberOfRecord = 0;
        try (Connection cn = DButil.getMyConnection()) {
            String query = "SELECT COUNT(Id) AS numOfQuestions FROM Questions WHERE ClosedDate IS NULL AND OwnerUserId = ?";
            PreparedStatement preparedStatement = cn.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    numberOfRecord = resultSet.getInt("numOfQuestions");
                    return (int) ((numberOfRecord - 1) / 10 + 1);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return numberOfRecord;
    }
}