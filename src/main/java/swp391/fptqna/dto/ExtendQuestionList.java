package swp391.fptqna.dto;

import java.util.ArrayList;

public class ExtendQuestionList extends ArrayList<ExtendedQuestionDTO> {
    public ExtendQuestionList() {
    }

    public ExtendedQuestionDTO getQuestionById(int id) {
        for (ExtendedQuestionDTO question : this){
            if (question.getId() == id) return question;
        }
        return null;
    }
}
