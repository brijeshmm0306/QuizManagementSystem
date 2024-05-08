package com.bm.validation;

import java.util.Map;

public interface Validation
{
	
	    boolean isValidTitle(String question);
	 
	    boolean isValidOption(String[] options);
	    
	    boolean isValidDifficulty(String difficulty);
	    
	    boolean isValidCategory(String topicTag);
}
