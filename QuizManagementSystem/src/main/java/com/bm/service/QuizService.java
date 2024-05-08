package com.bm.service;

import java.util.List;

import com.bm.model.QuizLibrary;

public interface QuizService {
	
public boolean saveQuiz(QuizLibrary quiz);
	
	public List<QuizLibrary> getAllQuiz();

	 public void updateQuiz(int quizId, String newQuizTitle);
	 
	 void deleteQuiz(int quizId);
	 
	 QuizLibrary getQuizById(int id);
}
