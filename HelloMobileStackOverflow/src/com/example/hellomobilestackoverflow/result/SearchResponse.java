package com.example.hellomobilestackoverflow.result;

import java.util.ArrayList;

import com.example.hellomobilestackoverflow.model.Question;
import com.google.gson.annotations.SerializedName;

/**
 * Response from the StackOverflow API while performing search
 * @author Maciej
 */
public class SearchResponse {

	public ArrayList<Question> items;
	
	@SerializedName("has_more")
	public boolean hasMore;
	
}
