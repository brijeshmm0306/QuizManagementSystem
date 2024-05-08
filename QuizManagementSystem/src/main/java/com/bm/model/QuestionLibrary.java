package com.bm.model;

import java.util.Arrays;


public class QuestionLibrary {
    
    private int questionId;
    
    private String question;
    
    private String[] options;
    
    private int correctAnswer;
    
    private String difficultyLevel;
    
    private String topicTag;     
    
    private int marks;

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String[] getOptions() {
        return options;
    }

    public void setOptions(String[] options)
    {
        this.options = options;
    }

    public int getCorrectAnswer() {
        return correctAnswer;
    }

    public void setCorrectAnswer(int correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public String getDifficultyLevel() {   
        return difficultyLevel;
    }

    public void setDifficultyLevel(String difficultyLevel) {  
        this.difficultyLevel = difficultyLevel;
    }

    public String getTopicTag() {   
        return topicTag;
    }

    public void setTopicTag(String topicTag) {  
        this.topicTag = topicTag;
    }
    
    public void setMarks(int marks) {
        this.marks = marks;
    }

    public int getMarks() {
        return marks;
    }

	@Override
	public String toString() {
		return "QuestionLibrary [questionId=" + questionId + ", question=" + question + ", options="
				+ Arrays.toString(options) + ", correctAnswer=" + correctAnswer + ", difficultyLevel=" + difficultyLevel
				+ ", topicTag=" + topicTag + ", marks=" + marks + "]";
	}

	public QuestionLibrary(int questionId, String question, String[] options, int correctAnswer, String difficultyLevel,
			String topicTag, int marks) {
		super();
		this.questionId = questionId;
		this.question = question;
		this.options = options;
		this.correctAnswer = correctAnswer;
		this.difficultyLevel = difficultyLevel;
		this.topicTag = topicTag;
		this.marks = marks;
	}
	
	 public QuestionLibrary(String question, int correctAnswer, String difficultyLevel, String topicTag, int marks, String[] options) {
	        setQuestion(question);
	        setCorrectAnswer(correctAnswer);
	        setDifficultyLevel(difficultyLevel);
	        setTopicTag(topicTag);
	        setMarks(marks);
	        setOptions(options);
	    }

	public QuestionLibrary() {
		super();
	}
	
	
	public void printOptions() {
        for (int i = 0; i < options.length; i++) {
            System.out.println((i + 1) + ". " + options[i]);
        }
	}
}