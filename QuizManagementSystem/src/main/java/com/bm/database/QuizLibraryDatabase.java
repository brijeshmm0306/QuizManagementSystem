package com.bm.database;

import java.util.ArrayList;
import java.util.List;

import com.bm.model.QuizLibrary;

public class QuizLibraryDatabase {
    private List<QuizLibrary> quizLibrary = new ArrayList<>();

    public List<QuizLibrary> getAllQuizzes() {
        return quizLibrary;
    }

      public boolean addQuiz(QuizLibrary quiz) {
        return quizLibrary.add(quiz);
    }
    
    
    public void updateQuizTitle(int quizId, String newTitle) {
        for (QuizLibrary quiz : quizLibrary) {
            if (quiz.getQuizId() == quizId) {
                quiz.setQuizTitle(newTitle);
                break;
            }
        }
    }
    
    
    public void deleteQuiz(int quizId) {
        quizLibrary.removeIf(quiz -> quiz.getQuizId() == quizId);
    }

    
}