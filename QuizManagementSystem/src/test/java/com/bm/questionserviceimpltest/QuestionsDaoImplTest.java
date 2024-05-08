package com.bm.questionserviceimpltest;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import com.bm.dao.QuestionsDao;
import com.bm.dao.QuestionsDaoImpl;
import com.bm.exception.EmptyQuestionException;
import com.bm.exception.QuestionIDNotFound;
import com.bm.model.QuestionLibrary;

import java.util.List;

class QuestionsDaoImplTest {

    private final QuestionsDao questionsDao = new QuestionsDaoImpl();

    @Test
    void testAddQuestion() {
       
        QuestionLibrary newQuestion = new QuestionLibrary();
        newQuestion.setQuestion("Test question?");

        assertDoesNotThrow(() -> questionsDao.addQuestion(newQuestion));
    }

    @Test
    void testAddEmptyQuestion() {
        // Test: Empty question cannot be added
        QuestionLibrary newQuestion = new QuestionLibrary();
        newQuestion.setQuestion("");

        assertThrows(EmptyQuestionException.class, () -> questionsDao.addQuestion(newQuestion));
    }

    @Test
    void testSeeAllQuestions() {
       
        QuestionLibrary newQuestion1 = new QuestionLibrary();
        newQuestion1.setQuestion("Question 1?");
        QuestionLibrary newQuestion2 = new QuestionLibrary();
        newQuestion2.setQuestion("Question 2?");

        assertDoesNotThrow(() -> questionsDao.addQuestion(newQuestion1));
        assertDoesNotThrow(() -> questionsDao.addQuestion(newQuestion2));

        List<QuestionLibrary> allQuestions = questionsDao.seeAllQuestions();

        assertTrue(allQuestions.contains(newQuestion1));
        assertTrue(allQuestions.contains(newQuestion2));
    }

    @Test
    void testDeleteQuestion() {
        // Test: Question can be deleted
        QuestionLibrary newQuestion = new QuestionLibrary();
        newQuestion.setQuestion("Question to be deleted?");

        assertDoesNotThrow(() -> questionsDao.addQuestion(newQuestion));
        List<QuestionLibrary> questionListBeforeDelete = questionsDao.seeAllQuestions();

        try {
			questionsDao.deleteQuestion(newQuestion.getQuestionId());
		} catch (QuestionIDNotFound e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        List<QuestionLibrary> questionListAfterDelete = questionsDao.seeAllQuestions();

        assertEquals(questionListBeforeDelete.size() - 1, questionListAfterDelete.size());
        assertFalse(questionListAfterDelete.contains(newQuestion));
    }
}