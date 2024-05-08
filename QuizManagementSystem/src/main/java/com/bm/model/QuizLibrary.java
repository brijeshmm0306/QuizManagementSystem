package com.bm.model;

import java.util.ArrayList;
import java.util.List;

public class QuizLibrary
{
    private int quizId;
    
    private String quizTitle;
    
    private List<QuestionLibrary> questions;
    
    private int totalMarks;

    public QuizLibrary(){
        questions = new ArrayList<>();
    }
    

    public QuizLibrary(int quizId, String quizTitle, List<QuestionLibrary> questions, int totalMarks) {
		super();
		this.quizId = quizId;
		this.quizTitle = quizTitle;
		this.questions = questions;
		this.totalMarks = totalMarks;
	}



	@Override
	public String toString() {
		return "QuizLibrary [quizId=" + quizId + ", quizTitle=" + quizTitle + ", questions=" + questions
				+ ", totalMarks=" + totalMarks + "]";
	}



	public int getQuizId() {
		return quizId;
	}



	public void setQuizId(int quizId) {
		this.quizId = quizId;
	}



	public String getQuizTitle() {
		return quizTitle;
	}



	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}



	public int getTotalMarks() {
		return totalMarks;
	}



	public void setTotalMarks(int totalMarks) {
		this.totalMarks = totalMarks;
	}



	public void setQuestions(List<QuestionLibrary> questions) {
		this.questions = questions;
	}



	public List<QuestionLibrary> getQuestions(){
        return questions;
    }

    public void addQuestion(QuestionLibrary question){
        questions.add(question);
    }



	public void setName(String newQuizTitle) {
		
		
	}
}