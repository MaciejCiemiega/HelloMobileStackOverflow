package com.example.hellomobilestackoverflow.activity.generic;

import com.example.hellomobilestackoverflow.R;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;

/**
 * Simple activity ready to host a child fragment
 * @author Maciej
 */
public abstract class SimpleActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(getContentViewResId());
	}
	
	/**
	 * @return resource id for content view layout
	 */
	protected int getContentViewResId() {
		return R.layout.simple_fragment_activity;
	}
	
	/**
	 * Commits new {@link android.support.v4.app.FragmentTransaction} that will replace current fragment with the given one inside R.id.content container.
	 * @param activity to obtain {@link android.support.v4.app.FragmentManager} from
	 * @param fragment to be added
	 */
	public static void addFragmentToContent(ActionBarActivity activity, Fragment fragment) {
		FragmentManager mFragmentManager = activity.getSupportFragmentManager();
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        mFragmentTransaction.replace(R.id.content, fragment);
        mFragmentTransaction.commit();
	}
}
