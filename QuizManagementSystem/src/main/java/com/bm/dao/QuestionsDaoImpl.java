package com.bm.dao;

import java.util.ArrayList;
import java.util.List;

import com.bm.exception.EmptyQuestionException;
import com.bm.exception.QuestionIDNotFound;
import com.bm.model.QuestionLibrary;

public class QuestionsDaoImpl implements QuestionsDao {

    private List<QuestionLibrary> quizQuestion;
    
    private int questionIdIncrementer;

    public QuestionsDaoImpl() 
    {
        this.quizQuestion = new ArrayList<QuestionLibrary>();
    
        this.questionIdIncrementer = 1;
    }

    @Override
    public void addQuestion(QuestionLibrary quizQuestions) throws EmptyQuestionException
    {
    	 if (quizQuestions.getQuestion() == null || quizQuestions.getQuestion().trim().isEmpty())
    	 {
    	        throw new EmptyQuestionException("Please enter a valid question.");
    	 }
        quizQuestions.setQuestionId(questionIdIncrementer);
    
        quizQuestion.add(quizQuestions);
        
        questionIdIncrementer++;
    }

	@Override
	public List<QuestionLibrary> seeAllQuestions() {

		return quizQuestion;
	}

//use streams
	@Override
	public void deleteQuestion(int questionId) {
	    if (quizQuestion.removeIf(ques -> ques.getQuestionId() == questionId)) {
	        System.out.println("Question deleted successfully!");
	    } else {
	        System.out.println("Question with " + questionId + " not found");
	    }
	}
}