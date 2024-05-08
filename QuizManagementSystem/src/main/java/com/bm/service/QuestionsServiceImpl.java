package com.bm.service;

import com.bm.model.QuestionLibrary;
import com.bm.database.*;
import java.util.List;

import com.bm.dao.*;
import com.bm.exception.EmptyQuestionException;
import com.bm.exception.QuestionIDNotFound;

public class QuestionsServiceImpl implements QuestionsService {

	QuestionsDaoImpl questionsDaoImpl = new QuestionsDaoImpl();
	
	 

	@Override
	public void addQuestion(QuestionLibrary quizQuestions) {

		try 
		{
			questionsDaoImpl.addQuestion(quizQuestions);
		} 
		catch (EmptyQuestionException e)
		{
			System.out.println(e.getMessage());
		}
	}
	

	@Override
	public List<QuestionLibrary> seeAllQuestions() {
		return questionsDaoImpl.seeAllQuestions();
	}

	@Override
	public void deleteQuestion(int questionId) {

		questionsDaoImpl.deleteQuestion(questionId);
	}

	public QuestionLibrary getQuestionById(int questionId) {
		List<QuestionLibrary> allQuestions = seeAllQuestions();
		for (QuestionLibrary question : allQuestions) {
			if (question.getQuestionId() == questionId) {
				return question;
			}
		}
		return null;
	}

	
}
