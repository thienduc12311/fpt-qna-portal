package swp391.fptqna.dto;

import java.util.ArrayList;

public class ExtendedAnswerList extends ArrayList<ExtendedAnswerDTO> {
    public ExtendedAnswerList() {
    }

    public ExtendedAnswerDTO getAnswerById(int id) {
        for (ExtendedAnswerDTO answer : this) {
            if (answer.getId() == id) return answer;
        }
        return null;
    }
}