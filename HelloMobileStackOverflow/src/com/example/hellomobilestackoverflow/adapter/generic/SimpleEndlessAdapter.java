package com.example.hellomobilestackoverflow.adapter.generic;

import android.content.Context;
import android.widget.ListAdapter;

import com.commonsware.cwac.endless.EndlessAdapter;
import com.example.hellomobilestackoverflow.R;

public abstract class SimpleEndlessAdapter extends EndlessAdapter {

	public SimpleEndlessAdapter(Context context, ListAdapter wrapped) {
		super(context, wrapped, R.layout.simple_endless_adapter_pending_item);
		setRunInBackground(false);
	}
	
	public abstract void doOnLoading();
	
	@Override
	protected boolean cacheInBackground() throws Exception {
		doOnLoading();
		return true;
	}
	
	@Override
	protected void appendCachedData() {
		// do nothing
	}
}
