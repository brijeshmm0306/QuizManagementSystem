package com.bm.service;

import java.util.List;

import com.bm.dao.QuizDaoImpl;
import com.bm.model.QuizLibrary;

public class QuizServiceImpl implements QuizService{
	
	QuizDaoImpl quizDaoImpl = new QuizDaoImpl();

	@Override
	public boolean saveQuiz(QuizLibrary quiz) {
		return quizDaoImpl.saveQuiz(quiz);
	}

	@Override
	public List<QuizLibrary> getAllQuiz() {
		return quizDaoImpl.getAllQuiz();
	}

	@Override
	public void updateQuiz(int quizId, String newQuizTitle) {
		quizDaoImpl.updateQuiz(quizId, newQuizTitle);
		
	}

	@Override
	public void deleteQuiz(int quizId) {
		quizDaoImpl.deleteQuiz(quizId);
	}

	@Override
    public QuizLibrary getQuizById(int id) {
        return quizDaoImpl.getQuizById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
    }
	
	

}
