package com.bm.dao;

import java.util.List;

import com.bm.exception.EmptyQuestionException;
import com.bm.exception.QuestionIDNotFound;
import com.bm.model.QuestionLibrary;

public interface QuestionsDao {
	
	public void addQuestion(QuestionLibrary quizQuestions) throws EmptyQuestionException;;
	
    List<QuestionLibrary> seeAllQuestions();
    
    void deleteQuestion(int questionId) throws QuestionIDNotFound;

}
