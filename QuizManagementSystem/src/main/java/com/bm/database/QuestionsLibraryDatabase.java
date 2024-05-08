package com.bm.database;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bm.model.QuestionLibrary;

public class QuestionsLibraryDatabase {
	
	private List<QuestionLibrary> questionLibraryQuestions = new ArrayList<QuestionLibrary>();
	
	public List<QuestionLibrary> getAllQuestions()
	{
        return questionLibraryQuestions;
    }
	
	public Iterator<QuestionLibrary> getIterator()
	{
	    return questionLibraryQuestions.iterator();
	}
	
	public void addQuestion(QuestionLibrary question)
	{
        questionLibraryQuestions.add(question);
    }

}
