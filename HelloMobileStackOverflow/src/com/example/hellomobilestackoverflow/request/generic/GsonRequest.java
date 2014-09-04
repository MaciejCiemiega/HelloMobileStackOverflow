package com.example.hellomobilestackoverflow.request.generic;

import java.io.UnsupportedEncodingException;

import com.android.volley.NetworkResponse;
import com.android.volley.ParseError;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.JsonRequest;
import com.google.gson.Gson;

/**
 * Simple request that can will try to parse response JSON string into object of given type with {@link Gson}
 * @param <T>
 * 
 * @author Maciej
 */
public abstract class GsonRequest<T> extends JsonRequest<T> {

	public GsonRequest(int method, String url, String requestBody, Listener<T> listener, ErrorListener errorListener) {
		super(method, url, requestBody, listener, errorListener);
	}

	@Override
    protected Response<T> parseNetworkResponse(NetworkResponse response) {
        try {
            String jsonString = new String(response.data, HttpHeaderParser.parseCharset(response.headers));
            
            return Response.success(new Gson().fromJson(jsonString, getObjectClass()), HttpHeaderParser.parseCacheHeaders(response));
        } catch (UnsupportedEncodingException e) {
            return Response.error(new ParseError(e));
        } catch (Exception je) {
            return Response.error(new ParseError(je));
        }
    }

	protected abstract Class<T> getObjectClass();
}
