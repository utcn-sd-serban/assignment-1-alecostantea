package ro.utcn.alecostantea.assignment1.persistence.api;

import ro.utcn.alecostantea.assignment1.model.Question;

import java.util.List;
import java.util.Optional;

public interface QuestionRepository {

    Question save(Question question);

    Optional<Question> findById(int id);

    void remove (Question question);

    List<Question> findAll();


}
