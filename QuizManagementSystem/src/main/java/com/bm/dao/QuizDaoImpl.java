package com.bm.dao;

import java.util.List;
import java.util.Optional;

import com.bm.model.QuizLibrary;
import com.bm.database.*;
public class QuizDaoImpl implements QuizDao
{
	
	QuizLibraryDatabase quizLibraryDatabase = new QuizLibraryDatabase();
	
	private List<QuizLibrary> quizzes;

	@Override
	public boolean saveQuiz(QuizLibrary quiz) {

		
		return quizLibraryDatabase.addQuiz(quiz);
		
	}

	@Override
	public List<QuizLibrary> getAllQuiz() {
		
		return quizLibraryDatabase.getAllQuizzes();
	}

	@Override
	public void updateQuiz(int quizId, String newQuizTitle) {
		quizLibraryDatabase.updateQuizTitle(quizId, newQuizTitle);
	}

	@Override
	public void deleteQuiz(int quizId) {
	   quizLibraryDatabase.deleteQuiz(quizId);
	}

	@Override
	public Optional<QuizLibrary> getQuizById(int id) {
		return quizLibraryDatabase.getAllQuizzes().stream()
                .filter(quiz -> quiz.getQuizId() == id)
                .findFirst();
	}

}