package com.example.hellomobilestackoverflow.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;

import com.example.hellomobilestackoverflow.R;
import com.example.hellomobilestackoverflow.activity.generic.SimpleActivity;

/**
 * Main activity containing search query input.
 * @author Maciej
 */
public class MainActivity extends SimpleActivity {

	@InjectView(R.id.searchQueryEditText) EditText searchQueryEditText;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		ButterKnife.inject(this, this);
		searchQueryEditText.setOnEditorActionListener(new OnEditorActionListener() {
			@Override
			public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
				if (actionId == EditorInfo.IME_ACTION_SEND) {
					onSearchButtonClicked();
					return true;
		        }
				return false;
			}
		});
		searchQueryEditText.setOnKeyListener(new OnKeyListener() {
			@Override
			public boolean onKey(View v, int keyCode, KeyEvent event) {
				if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
					onSearchButtonClicked();
					return true;
		        }
				return false;
			}
		});
	}
	
	@Override
	protected int getContentViewResId() {
		return R.layout.main_activity;
	}
	
	
	// ====================
	// Buttons
	// ====================
	@OnClick(R.id.searchButton)
	public void onSearchButtonClicked() {
		final String searchQuery = trimSearchQuery(searchQueryEditText.getText().toString());
		if (!TextUtils.isEmpty(searchQuery)) {
			SearchListActivity.startActivity(this, searchQuery);
		}
	}
	
	public static String trimSearchQuery(String searchQuery) {
		return searchQuery.trim();
	}
}
