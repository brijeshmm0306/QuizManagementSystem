package com.bm.validation;

import java.util.List;

import com.bm.model.QuestionLibrary;

public interface QuizValidator {
	boolean isValidQuizName(String quizName) ;
	boolean isValidSelectedQuestions(List<QuestionLibrary> selectedQuestions);


}
