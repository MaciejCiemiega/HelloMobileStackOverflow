package com.example.hellomobilestackoverflow.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.example.hellomobilestackoverflow.R;
import com.example.hellomobilestackoverflow.model.Question;

/**
 * This fragment displays details page of given question. Results are presented in a {@link #android.webkit.WebView}. <br/>
 * Questions are loaded though the {@link #loadQuestion(Question)} method. <br/>
 * This fragment automatically changes the {@link ActionBar} title to reflect the question title. 
 * @author Maciej
 */
public class QuestionDetailsFragment extends Fragment {
	
	private final static String EXTRA_QUESTION_ITEM_KEY = "question_item";
	
	@InjectView(R.id.webView) WebView webView;
	@InjectView(R.id.selectQuestionHintView) View selectQuestionHintView;

	private Question question;
	
	/**
	 * @param question that will be loaded at start
	 * @return new instance of {@link QuestionDetailsFragment}
	 */
	public static QuestionDetailsFragment newInstance(Question question) {
		final QuestionDetailsFragment fragment = new QuestionDetailsFragment();
		final Bundle args = new Bundle();
		args.putParcelable(EXTRA_QUESTION_ITEM_KEY, question);
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		return inflater.inflate(R.layout.question_details_fragment, container, false);
	}
	
	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ButterKnife.inject(this, view);
		
		ViewCompat.setLayerType(webView, ViewCompat.LAYER_TYPE_SOFTWARE, null);
	}
	
	@Override
	public void onViewStateRestored(Bundle savedInstanceState) {
		super.onViewStateRestored(savedInstanceState);
		
		Question question = null;
		if(getArguments() != null) {
			question = getArguments().getParcelable(EXTRA_QUESTION_ITEM_KEY);
		} else if (savedInstanceState != null) {
			question = savedInstanceState.getParcelable(EXTRA_QUESTION_ITEM_KEY);
		}
		
		if(question != null) {
			loadQuestion(question);
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putParcelable(EXTRA_QUESTION_ITEM_KEY, question);
	}
	
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		ButterKnife.reset(this);
	}
	
	
	// ====================
	// Loading content
	// ====================
	/**
	 * This method tries to load a new question in the {@link WebView} and hides the hint text right after that.
	 * @param question to be loaded
	 */
	public void loadQuestion(Question question) {
		if(question != null) {
			this.question = question;
			webView.loadUrl(question.link);
			selectQuestionHintView.setVisibility(View.GONE);
			updateActivityTitle(question.title);
		}
	}
	
	private void updateActivityTitle(String title) {
		if(getActivity() instanceof ActionBarActivity) {
			((ActionBarActivity)getActivity()).getSupportActionBar().setTitle(title);
		}
	}
}