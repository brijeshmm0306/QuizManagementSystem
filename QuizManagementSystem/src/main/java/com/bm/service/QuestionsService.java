package com.bm.service;

import java.util.List;

import com.bm.model.QuestionLibrary;

public interface QuestionsService {

	public void addQuestion(QuestionLibrary quizQuestions);
	
	List<QuestionLibrary> seeAllQuestions();
	
	 void deleteQuestion(int questionId);
}
