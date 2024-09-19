package com.pa.filters;

public class Filters {
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

 }
