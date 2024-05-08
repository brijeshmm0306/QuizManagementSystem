package com.bm.validation;

import java.util.List;

import com.bm.model.QuestionLibrary;

public class QuizValidatorImpl implements QuizValidator{


    public boolean isValidQuizName(String quizName) {
        return !(quizName == null || quizName.trim().isEmpty());
    }

	@Override
	public boolean isValidSelectedQuestions(List<QuestionLibrary> selectedQuestions) {

		 return !(selectedQuestions == null || selectedQuestions.isEmpty());
	}
}

