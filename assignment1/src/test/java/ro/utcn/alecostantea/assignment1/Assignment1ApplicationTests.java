package ro.utcn.alecostantea.assignment1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ro.utcn.alecostantea.assignment1.model.Question;
import ro.utcn.alecostantea.assignment1.model.User;
import ro.utcn.alecostantea.assignment1.persistence.api.RepositoryFactory;
import ro.utcn.alecostantea.assignment1.persistence.memory.InMemoryRepositoryFactory;

public class Assignment1ApplicationTests {
	final private RepositoryFactory factory = new InMemoryRepositoryFactory();

	@Before
	public void fill(){
		Question question1 = new Question(0,"title1","text1","ale");
		Question question2 = new Question(0,"title2","text2","ale");
		Question question3 = new Question(0,"title3","text3","ale");
		factory.createQuestionRepository().save(question1);
		factory.createQuestionRepository().save(question2);
		factory.createQuestionRepository().save(question3);
	}

	@Test
	public void testAddQuestion(){
		int beforeLen = factory.createQuestionRepository().findAll().size();
		Question question = new Question(0,"title4","text4","ale");
		question = factory.createQuestionRepository().save(question);
		int afterLen = factory.createQuestionRepository().findAll().size();

		Assert.assertEquals(beforeLen+1,afterLen);
	}

	@Test
	public void testRemoveQuestion(){
		int beforeLen = factory.createQuestionRepository().findAll().size();
		Question question = factory.createQuestionRepository().findById(1).get();
		factory.createQuestionRepository().remove(question);
		int afterLen = factory.createQuestionRepository().findAll().size();

		Assert.assertEquals(beforeLen-1,afterLen);

	}

	@Test
	public void testAddUser(){
		int beforeLen = factory.createUserRepository().findAll().size();
		User user = new User(0,"ale","ale");
		user = factory.createUserRepository().save(user);
		int afterLen = factory.createUserRepository().findAll().size();
		Assert.assertEquals(beforeLen+1,afterLen);
	}


}
