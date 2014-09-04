package com.example.hellomobilestackoverflow.activity.generic;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

/**
 * Simple sub activity that automatically handles click on the {@link android.R.id.home} button in {@link ActionBar} and invoke {@link #onBackPressed()} method.
 * @author Maciej
 */
public abstract class SimpleSubActivity extends SimpleActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setDisplayShowHomeEnabled(true);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if(item.getItemId()==android.R.id.home) {
			onBackPressed();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
