package com.bm.dao;

import java.util.List;
import java.util.Optional;

import com.bm.model.QuizLibrary;

public interface QuizDao {
	
	public boolean saveQuiz(QuizLibrary quiz);
	
	public List<QuizLibrary> getAllQuiz();
	
   public void updateQuiz(int quizId, String newQuizTitle);
   
   void deleteQuiz(int quizId);
   
   Optional<QuizLibrary> getQuizById(int id);

}