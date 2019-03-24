package ro.utcn.alecostantea.assignment1.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ro.utcn.alecostantea.assignment1.model.Question;
import ro.utcn.alecostantea.assignment1.persistence.api.RepositoryFactory;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class QuestionService {

    private final RepositoryFactory factory;

    @Transactional
    public Question save(Question question){

       return factory.createQuestionRepository().save(question);

    }
    @Transactional
    public Optional<Question> findById(int id){

        return factory.createQuestionRepository().findById(id);
    }
    @Transactional
    public void remove(Question question){

        factory.createQuestionRepository().remove(question);

    }
    @Transactional
    public List<Question> findAll(){

        return factory.createQuestionRepository().findAll();
    }


}

