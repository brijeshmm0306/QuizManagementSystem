package com.bm.validation;

import java.util.Arrays;
import java.util.Map;

public class InputValidationImpl implements Validation {

	@Override
	public boolean isValidTitle(String question) {
		return !(question == null || question.trim().isEmpty());

	}

	@Override
	public boolean isValidOption(String[] options) {
		for (String option : options)
		{
	        if (option == null || option.trim().isEmpty())
	        {
	            return false;
	        }
	    }
	    return true;
	}

	@Override
	public boolean isValidDifficulty(String difficulty) {
		return (Arrays.asList("easy","medium","hard").contains(difficulty.toLowerCase()));
	}

	@Override
	public boolean isValidCategory(String topicTag) {
		return !(topicTag == null || topicTag.trim().isEmpty());
	}
    
}