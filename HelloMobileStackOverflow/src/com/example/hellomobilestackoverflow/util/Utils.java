package com.example.hellomobilestackoverflow.util;

import android.content.Context;
import android.widget.Toast;

import com.example.hellomobilestackoverflow.R;

public class Utils {

	public static void showToastError(Context context) {
		showToast(context, R.string.generic_error);
	}

	public static void showToast(Context context, int textResId) {
		showToast(context, context.getString(textResId));
	}
	
	public static void showToast(Context context, String text) {
		showToast(context, text, false);
	}
	
	public static void showToast(Context context, String text, boolean isLong) {
		Toast.makeText(context.getApplicationContext(), text, isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT).show();
	}
	
}
