package com.example.hellomobilestackoverflow.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.hellomobilestackoverflow.R;
import com.example.hellomobilestackoverflow.activity.generic.SimpleActivity;
import com.example.hellomobilestackoverflow.activity.generic.SimpleSubActivity;
import com.example.hellomobilestackoverflow.fragment.QuestionDetailsFragment;
import com.example.hellomobilestackoverflow.fragment.SearchListFragment;
import com.example.hellomobilestackoverflow.fragment.SearchListFragment.OnQuestionSelectedListener;
import com.example.hellomobilestackoverflow.fragment.SearchListFragment.SearchQueryProvider;
import com.example.hellomobilestackoverflow.model.Question;

/**
 * Activity that shown list of questions and (on larger screens) also details of selected question.
 * @author Maciej
 */
public class SearchListActivity extends SimpleSubActivity implements SearchQueryProvider, OnQuestionSelectedListener {

	private final static String EXTRA_QUERY_KEY = "query";
	
//	@Optional @InjectView(R.id.slidingPaneLayout) SlidingPaneLayout slidingPaneLayout;
	private SearchListFragment searchListFragment;
	private QuestionDetailsFragment questionDetailsFragment;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
//		ButterKnife.inject(this, this);
		searchListFragment = (SearchListFragment) getSupportFragmentManager().findFragmentById(R.id.searchListFragment);
		questionDetailsFragment = (QuestionDetailsFragment) getSupportFragmentManager().findFragmentById(R.id.questionDetailsFragment);
		
//		if(slidingPaneLayout != null) {
//			slidingPaneLayout.post(new Runnable() {
//				public void run() {
//					slidingPaneLayout.openPane();
//				}
//			});
//		}
		
		if (searchListFragment == null && savedInstanceState == null) {						// init SearchListFragment in "phone" layout
			SimpleActivity.addFragmentToContent(this, SearchListFragment.newInstance());
		}
		
		getSupportActionBar().setTitle(getString(R.string.search_list_activity_title, getSearchQuery()));
	}
	
	@Override
	protected int getContentViewResId() {
		return R.layout.search_list_activity;
	}
	
	
	// ====================
	// Buttons
	// ====================
//	@Override
//	public void onBackPressed() {
//		if(isSlidingPaneClosed()) {
//			slidingPaneLayout.openPane();
//			return;
//		}
//		super.onBackPressed();
//	}
	
	@Override
	public void onQuestionSelected(SearchListFragment fragment, int position, Question question) {
		if(questionDetailsFragment == null) {							// "phone" layout
			QuestionDetailsActivity.startActivity(this, question);
		} else {														// "tablet" layout
			questionDetailsFragment.loadQuestion(question);
//			if(slidingPaneLayout != null) {
//				slidingPaneLayout.closePane();
//			}
		}
	}
	
//	private boolean isSlidingPaneClosed() {
//		return slidingPaneLayout!=null && !slidingPaneLayout.isOpen();
//	}

	
	// ====================
	// SearchQueryProvider
	// ====================
	@Override
	public String getSearchQuery() {
		return getIntent().getStringExtra(EXTRA_QUERY_KEY);
	}
	
	
	// ====================
	// StartActivity
	// ====================
	public final static void startActivity(Context context, String query) {
		final Intent intent = new Intent(context, SearchListActivity.class);
		intent.putExtra(EXTRA_QUERY_KEY, query);
		context.startActivity(intent);
	}
}
