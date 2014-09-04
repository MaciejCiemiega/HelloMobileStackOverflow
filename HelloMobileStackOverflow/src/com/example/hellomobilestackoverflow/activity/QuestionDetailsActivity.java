package com.example.hellomobilestackoverflow.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.hellomobilestackoverflow.activity.generic.SimpleActivity;
import com.example.hellomobilestackoverflow.activity.generic.SimpleSubActivity;
import com.example.hellomobilestackoverflow.fragment.QuestionDetailsFragment;
import com.example.hellomobilestackoverflow.model.Question;

/**
 * Activity that shown details of given question, presented in a WebView
 * @author Maciej
 */
public class QuestionDetailsActivity extends SimpleSubActivity {

	private final static String EXTRA_QUESTION_ITEM_KEY = "question_item";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		if(savedInstanceState==null) {
			final Question question = getIntent().getParcelableExtra(EXTRA_QUESTION_ITEM_KEY);
			SimpleActivity.addFragmentToContent(this, QuestionDetailsFragment.newInstance(question));
		}
	}
	
	// ====================
	// StartActivity
	// ====================
	public final static void startActivity(Context context, Question question) {
		final Intent intent = new Intent(context, QuestionDetailsActivity.class);
		intent.putExtra(EXTRA_QUESTION_ITEM_KEY, question);
		context.startActivity(intent);
	}
	
}
