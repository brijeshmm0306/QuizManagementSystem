package com.bm.questionserviceimpltest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bm.dao.QuizDao;
import com.bm.dao.QuizDaoImpl;
import com.bm.exception.AdminAlreadyExistsException;
import com.bm.exception.EmptyQuestionException;
import com.bm.exception.QuestionIDNotFound;
import com.bm.exception.UserAlreadyExistsException;
import com.bm.model.QuestionLibrary;
import com.bm.model.QuizLibrary;
import com.bm.service.QuizService;
import com.bm.service.QuizServiceImpl;
import com.bm.validation.QuizValidator;
import com.bm.validation.QuizValidatorImpl;

class QuizServiceTest {
	private QuizValidator validator;
	private QuizService quizService;
	private QuizDao quizDao;

	@BeforeEach
	void setUp() {
		validator = new QuizValidatorImpl();
		quizService = new QuizServiceImpl();
		quizDao = new QuizDaoImpl();
	}

	@Test
    public void testValidQuizName() {
        assertTrue(validator.isValidQuizName("Java Quiz"));
    }

    @Test
    public void testEmptyString() {
        assertFalse(validator.isValidQuizName(""));
    }

    @Test
    public void testNullInput() {
        assertFalse(validator.isValidQuizName(null));
    }

    @Test
    public void testWhitespaceCharactersOnly() {
        assertFalse(validator.isValidQuizName("     "));
    }

    @Test
    public void testLeadingAndTrailingWhitespace() {
        assertTrue(validator.isValidQuizName("  Python Quiz  "));
    }

    @Test
    public void testSingleCharacterName() {
        assertTrue(validator.isValidQuizName("A"));
    }

    @Test
    public void testValidQuizNameWithSpecialCharacters() {
        assertTrue(validator.isValidQuizName("Java Quiz: Core Java Quiz"));
    }

    @Test
    public void testInvalidQuizNameWithSpecialCharacters() {
        assertTrue(validator.isValidQuizName("Quiz?"));
    }

    @Test
    public void testValidQuizNameWithNumbers() {
        assertTrue(validator.isValidQuizName("Java Quiz 123"));
    }

    @Test
    public void testInvalidQuizNameWithNumbers() {
        assertTrue(validator.isValidQuizName("123"));
    }
    @Test
    void testValidSelectedQuestions()
    {
        List<QuestionLibrary> selectedQuestions = new ArrayList<>();
        String[] options1 = {"Hello", "hello1", "hello2", "hello 2"};
        QuestionLibrary newQuestion = new QuestionLibrary("hello", 1, "hard", "oops", 2, options1);

        String[] options2 = {"Option A", "Option B", "Option C", "option 4"};
        QuestionLibrary newQuestion2 = new QuestionLibrary("hello", 1, "hard", "oops", 2, options2);

        selectedQuestions.add(newQuestion);
        selectedQuestions.add(newQuestion2);

        assertTrue(validator.isValidSelectedQuestions(selectedQuestions));
    }

    @Test
    public void testEmptyList() {
        List<QuestionLibrary> selectedQuestions = new ArrayList<>();
        assertFalse(validator.isValidSelectedQuestions(selectedQuestions));
    }

    @Test
    public void testNullInputQuestion() {
        assertFalse(validator.isValidSelectedQuestions(null));
    }
    
    @Test
    void testCreateQuiz() {
        List<QuestionLibrary> selectedQuestions = new ArrayList<>();
        String[] options1 = {"Hello", "hello1", "hello2", "hello 2"};
        QuestionLibrary newQuestion = new QuestionLibrary();
        newQuestion.setQuestion("hello");
        newQuestion.setCorrectAnswer(1);
        newQuestion.setDifficultyLevel("hard");
        newQuestion.setTopicTag("oops");
        newQuestion.setMarks(2);
        newQuestion.setOptions(options1);

        String[] options2 = {"Option A", "Option B", "Option C", "option 4"};
        QuestionLibrary newQuestion2 = new QuestionLibrary();
        newQuestion2.setQuestion("hello");
        newQuestion2.setCorrectAnswer(1);
        newQuestion2.setDifficultyLevel("hard");
        newQuestion2.setTopicTag("oops");
        newQuestion2.setMarks(2);
        newQuestion2.setOptions(options2);

        selectedQuestions.add(newQuestion);
        selectedQuestions.add(newQuestion2);
        QuizLibrary quiz = new QuizLibrary();  
        quiz.setQuizTitle("New Quiz Title");   
        quiz.setQuestions(selectedQuestions);  

        assertEquals(true, quizService.saveQuiz(quiz));

    }
	
    @Test
    void testValidSelected() {
        List<QuestionLibrary> selectedQuestions = new ArrayList<>();
        String[] options1 = {"Hello", "hello1", "hello2", "hello 2"};
        
        QuestionLibrary newQuestion = new QuestionLibrary();
        newQuestion.setQuestion("hello");
        newQuestion.setCorrectAnswer(1);
        newQuestion.setDifficultyLevel("hard");
        newQuestion.setTopicTag("oops");
        newQuestion.setMarks(2);
        newQuestion.setOptions(options1);

        String[] options2 = {"Option A", "Option B", "Option C", "option 4"};
        QuestionLibrary newQuestion2 = new QuestionLibrary();
        newQuestion2.setQuestion("hello");
        newQuestion2.setCorrectAnswer(1);
        newQuestion2.setDifficultyLevel("hard");
        newQuestion2.setTopicTag("oops");
        newQuestion2.setMarks(2);
        newQuestion2.setOptions(options2);
        
        selectedQuestions.add(newQuestion);
        selectedQuestions.add(newQuestion2);

        assertTrue(validator.isValidSelectedQuestions(selectedQuestions));
    }

  	

    
    @Test
    void deleteQuizSuccessfully() {
       
        QuestionLibrary question1 = new QuestionLibrary();
        question1.setQuestion("Q1");
        question1.setOptions(new String[]{"Option 1", "Option 2","Option 3","Option 4"});
        question1.setCorrectAnswer(1);
       

        QuestionLibrary question2 = new QuestionLibrary();
        question2.setQuestion("Q2");
        question2.setOptions(new String[]{"Option a", "Option b", "Option c","Option d"});
        question2.setCorrectAnswer(1);
       

        List<QuestionLibrary> selectedQuestions = new ArrayList<>();
        selectedQuestions.add(question1);
        selectedQuestions.add(question2);

        QuizLibrary quiz = new QuizLibrary();
        quiz.setQuizTitle("Test Quiz");
        quiz.setQuestions(selectedQuestions);
       

        quizService.saveQuiz(quiz);  
        int quizId = quiz.getQuizId(); 

        
        assertTrue(quizDao.getQuizById(quizId).isPresent(), "Quiz should exist before deletion");

        
        quizDao.deleteQuiz(quizId);

        
        assertTrue(quizDao.getQuizById(quizId).isEmpty(), "Quiz should not exist after deletion");
    }
    
    @Test
    void getAllQuizzes_ReturnsNonEmptyList_WhenQuizzesArePresent() {
      
        List<QuizLibrary> allQuizzes = quizService.getAllQuiz();

        assertFalse(allQuizzes.isEmpty(), "Expected at least one quiz, but got an empty list");
    }

    @Test
    void updateQuiz_UpdatesQuizTitle_WhenQuizExists() {
       
        QuizLibrary existingQuiz = new QuizLibrary();
        
        quizService.saveQuiz(existingQuiz);
        
        String updatedTitle = "Updated Quiz Title";

       
        quizService.updateQuiz(existingQuiz.getQuizId(), updatedTitle);

     
        QuizLibrary resultQuiz = quizService.getQuizById(existingQuiz.getQuizId());
        
        assertEquals(updatedTitle, resultQuiz.getQuizTitle(), "Quiz title was not updated correctly");
    }

    @Test
    void deleteQuiz_DeletesQuiz_WhenQuizExists() {
        
        QuizLibrary existingQuiz = new QuizLibrary();
       
        quizService.saveQuiz(existingQuiz);
        
        
        quizService.deleteQuiz(existingQuiz.getQuizId());

        
        QuizLibrary resultQuiz = quizService.getQuizById(existingQuiz.getQuizId());
        assertNull(resultQuiz, "Expected quiz to be deleted, but it was still found");
    }

}