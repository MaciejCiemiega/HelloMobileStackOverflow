package com.example.hellomobilestackoverflow.adapter;

import java.util.List;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import butterknife.ButterKnife;
import butterknife.InjectView;

import com.example.hellomobilestackoverflow.R;
import com.example.hellomobilestackoverflow.model.Question;
import com.squareup.picasso.Picasso;

/**
 * Adapter responsible for displaying items (questions) of the search result
 * @author Maciej
 */
public class SearchListAdapter extends BaseAdapter {

	private final Context context;
	private List<Question> items;
	
	public SearchListAdapter(Context context) {
		this.context = context;
	}
	
	public void setItems(List<Question> items) {
		this.items = items;
		notifyDataSetChanged();
	}
	
	@Override
	public int getCount() {
		return items!=null ? items.size() : 0;
	}

	@Override
	public Question getItem(int position) {
		if (items != null && position >= 0 && position < getCount()) {
			return items.get(position);
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return getItem(position).questionId;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (convertView != null) {
			holder = (ViewHolder) convertView.getTag();
		} else {
			convertView = LayoutInflater.from(context).inflate(R.layout.search_list_fragment_list_item, parent, false);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		}

		final Question question = getItem(position);
		if(question.owner!=null && !TextUtils.isEmpty(question.owner.profileImage)) {
			Picasso.with(context)
				.load(question.owner.profileImage)
				.placeholder(R.drawable.ic_launcher)
				.error(R.drawable.ic_launcher)
				.fit()
				.into(holder.ownerProfileImageView);
			holder.ownerProfileImageView.setContentDescription(question.owner.displayName);
		} else {
			Picasso.with(context).cancelRequest(holder.ownerProfileImageView);
			holder.ownerProfileImageView.setImageDrawable(null);
			holder.ownerProfileImageView.setContentDescription(null);
		}
		
		holder.ownerView.setText(question.owner!=null ? question.owner.displayName : null);
		holder.answersCountView.setText(context.getString(R.string.search_list_fragment_answers_count, question.answerCount));
		holder.titleView.setText(question.title);
		
		return convertView;
	}
	
	static class ViewHolder {
	    @InjectView(R.id.ownerProfileImageView) ImageView ownerProfileImageView;
	    @InjectView(R.id.ownerView) TextView ownerView;
	    @InjectView(R.id.answersCountView) TextView answersCountView;
	    @InjectView(R.id.titleView) TextView titleView;

	    public ViewHolder(View view) {
	      ButterKnife.inject(this, view);
	    }
	  }
}
