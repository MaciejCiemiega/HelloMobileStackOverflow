package com.example.hellomobilestackoverflow.fragment;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout.OnRefreshListener;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.example.hellomobilestackoverflow.R;
import com.example.hellomobilestackoverflow.adapter.SearchListAdapter;
import com.example.hellomobilestackoverflow.adapter.generic.SimpleEndlessAdapter;
import com.example.hellomobilestackoverflow.fragment.generic.SwipeRefreshListFragment;
import com.example.hellomobilestackoverflow.model.Question;
import com.example.hellomobilestackoverflow.request.SearchRequest;
import com.example.hellomobilestackoverflow.result.SearchResponse;
import com.example.hellomobilestackoverflow.util.Utils;

/**
 * {@link SearchListFragment} Displays list of questions downloaded from the StackOverflow API.<br/>
 * Questions are downloaded in pages (size set to 20) and new pages are downloaded while scrolling down to the end of the list.<br/>
 * User can refresh the list by making swipe-to-refresh gesture as well as by clicking dedicated action item.<br/>
 * @author Maciej
 */
public class SearchListFragment extends SwipeRefreshListFragment implements OnRefreshListener {

	private SearchQueryProvider searchQueryProvider;
	private OnQuestionSelectedListener onQuestionSelectedListener;
	
	private ArrayList<Question> list;
	private RequestQueue mRequestQueue;
	
	protected SimpleEndlessAdapter endlessAdapter;
	private SearchListAdapter adapter;
	
	private final static int PAGE_SIZE = 20;
	
	private final static String EXTRA_LIST_KEY = "list";
	
	public static SearchListFragment newInstance() {
		return new SearchListFragment();
	}

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		if(activity instanceof SearchQueryProvider)
			searchQueryProvider = (SearchQueryProvider)activity;
		if(activity instanceof OnQuestionSelectedListener)
			onQuestionSelectedListener = (OnQuestionSelectedListener)activity;
	}
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mRequestQueue = Volley.newRequestQueue(getActivity());
		if(savedInstanceState!=null)
			this.list = savedInstanceState.getParcelableArrayList(EXTRA_LIST_KEY);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		
		setHasOptionsMenu(true);
		setOnRefreshListener(this);
		setColorScheme(R.color.orange_main, R.color.orange_dark, R.color.orange_main, R.color.orange_dark);
		
		adapter = new SearchListAdapter(getActivity());
		endlessAdapter = new SimpleEndlessAdapter(getActivity(), adapter) {
			public void doOnLoading() {
				getNextListPage();
			}
		};
		setListAdapter(endlessAdapter);
		setEmptyText(getString(R.string.search_list_fragment_empty_list));
		
		if(list!=null)
			setNewList(list, false);
		else
			getNewList();
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		outState.putParcelableArrayList(EXTRA_LIST_KEY, list);
		super.onSaveInstanceState(outState);
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		adapter = null;
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		
		mRequestQueue.cancelAll(this);
		mRequestQueue = null;
		list = null;
	}
	
	// ====================
	// Refreshing content
	// ====================
	@Override
	public void onRefresh() {
		getNewList();
	}
	
	/**
	 * Download new list that will replace current results
	 */
	protected void getNewList() {
		getNewList(false);
	}

	/**
	 * Download new list page that will be appended at the end of current list
	 */
	private void getNextListPage() {
		getNewList(true);
	}
	
	/**
	 * If first page is being downloaded - the current result will be erased and {@link ListView} will be hidden, showing only the spinning progress bar.
	 * @param isNextPage indicated whether the page is the first or next one
	 */
	private void getNewList(final boolean isNextPage) {
		if(!isNextPage) {
			list = null;
		}
		
		final String searchQuery = searchQueryProvider != null ? searchQueryProvider.getSearchQuery() : null;
		if(TextUtils.isEmpty(searchQuery))
			return;
		
		try {
			final Context appContext = getActivity().getApplicationContext();
			final int pageId = (list != null ? list.size() / PAGE_SIZE : 0) + 1;
			final SearchRequest searchRequest = new SearchRequest(searchQuery, pageId, PAGE_SIZE,
				new Listener<SearchResponse>() {
					public void onResponse(SearchResponse response) {
						setNewList(response != null ? response.items : null, isNextPage);
					}
				},
				new ErrorListener() {
					@Override
					public void onErrorResponse(VolleyError error) {
						Utils.showToastError(appContext);
						setNewList(null, isNextPage);
					}
				});
			searchRequest.setTag(this);
			mRequestQueue.cancelAll(this);
			mRequestQueue.add(searchRequest);

			if (!isNextPage && getListView() != null) {		// hide ListView and show progress bar only when loading the first page
				setListShownNoAnimation(false);
			}
		} catch (Exception e) {
			e.printStackTrace();
			Utils.showToastError(getActivity());
			setNewList(null, isNextPage);
		}
	}
	
	/**
	 * @param newList containing new results, may be null
	 * @param appendResults
	 */
	protected void setNewList(ArrayList<Question> newList, boolean appendResults) {
		if (appendResults) {
			if (newList == null) {
				this.list = newList;
			} else if (newList != null) {
				this.list.addAll(newList);
			}
		} else {
			this.list = newList;
		}

		if (getView() == null) {
			return;
		}

		setRefreshing(false);
		setListShown(true);
		adapter.setItems(this.list);
		endlessAdapter.onDataReady();
		if (newList != null && newList.size() >= PAGE_SIZE) {
			endlessAdapter.restartAppending();
		} else {
			endlessAdapter.stopAppending();
		}
		
		if (!appendResults) {
			getListView().setSelection(0);				// reset list scroll position after setting new list
		}
	}

	
	// ====================
	// Buttons
	// ====================
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		if(onQuestionSelectedListener!=null) {
			final Question question = adapter.getItem(position);
			onQuestionSelectedListener.onQuestionSelected(this, position, question);
		}
	}
	
	
	// ====================
	// Menu
	// ====================
	@Override
	public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
		inflater.inflate(R.menu.search_list_fragment, menu);
		super.onCreateOptionsMenu(menu, inflater);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == R.id.refreshItem) {
			setRefreshing(true);
			onRefresh();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	// ====================
	// Interface
	// ====================
	/**
	 * Implement this interface by activity to provide search query to attached {@link SearchListFragment}
	 * @author Maciej
	 */
	public static interface SearchQueryProvider {
		public String getSearchQuery();
	}
	
	/**
	 * Implement this interface in activity that hosts {@link SearchListFragment} to receive callbacks once new question has been selected from the list
	 * @author Maciej
	 */
	public static interface OnQuestionSelectedListener {
		public void onQuestionSelected(SearchListFragment fragment, int position, Question question);
	}
}
