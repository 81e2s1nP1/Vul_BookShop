package com.pa.filters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

@Component
public class Filters {
	// filter sql injection
	public String sqliFilters(String query) {
	    StringBuilder filteredQuery = new StringBuilder();
	    
	    for (int i = 0; i < query.length(); i++) {
	        char c = query.charAt(i);
	               if (c != '-' && c != '\'') {
	            	   filteredQuery.append(c);
	        }
	    }
	    
	    return filteredQuery.toString();
	}
	
	// filter command injection
	public String CIFilter(String command) {
	    Set<Character> filters = new HashSet<>(Arrays.asList('|', ';'));
	    StringBuilder newCommand = new StringBuilder();
	    
	    for (int i = 0; i < command.length(); i++) {
	        char currentChar = command.charAt(i);
	        
	        if (!filters.contains(currentChar)) {
	            newCommand.append(currentChar);
	        }
	    }
	    return newCommand.toString();
	}

 }
