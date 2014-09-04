package com.example.hellomobilestackoverflow.request;

import java.net.URLEncoder;

import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.example.hellomobilestackoverflow.request.generic.GsonRequest;
import com.example.hellomobilestackoverflow.result.SearchResponse;

/**
 * Network request to download list of last questions from StackOverflow API 
 * @author Maciej
 */
public class SearchRequest extends GsonRequest<SearchResponse> {

	private final static String SEARCH_URL = "http://api.stackexchange.com/2.2/search?page=%1$d&pagesize=%2$d&order=desc&sort=activity&intitle=%3$s&site=stackoverflow";
	
	/**
	 * @param query to perform a search in questions title
	 * @param pageId id of the page to download
	 * @param pageSize number of items that should be downloaded on one page
	 * @param listener
	 * @param errorListener
	 */
	public SearchRequest(String query, int pageId, int pageSize, Listener<SearchResponse> listener, ErrorListener errorListener) {
		super(Method.GET, formatUrl(query, pageId, pageSize), null, listener, errorListener);
	}
	
	@Override
	protected Class<SearchResponse> getObjectClass() {
		return SearchResponse.class;
	}

	private final static String formatUrl(String query, int pageId, int pageSize) {
		String encodedQuery;
		try {
			encodedQuery = URLEncoder.encode(query, "utf-8");
		} catch (Exception e) {
			e.printStackTrace();
			encodedQuery = query;
		}
		return String.format(SEARCH_URL, pageId, pageSize, encodedQuery);
	}

}
