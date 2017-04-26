package com.samirsayegh.marvelchars.domain.services.base;

import com.google.gson.GsonBuilder;
import com.samirsayegh.marvelchars.domain.services.Api;
import com.samirsayegh.marvelchars.domain.utils.HashConverter;

import java.io.IOException;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by yormirsamir.sayegh on 26/04/2017.
 */

public class BaseService implements Interceptor {

    private static final String API_KEY = "b7c7332d0d25237cc17604ecc7fb21d6";
    private static final String PRIVATE_KEY = "d8d1ff91093fe9ada88b455b04b4eeb799203bd6";

    private static final String API_KEY_NAME = "apikey";
    private static final String TIME_STAMP_NAME = "ts";
    private static final String HASH_NAME = "hash";

    private static final String URL = "https://gateway.marvel.com:443";

    protected final Api api;

    public BaseService() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SS");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .client(okHttpClient())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder.create()))
                .build();
        api = retrofit.create(Api.class);
    }

    private OkHttpClient okHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient().newBuilder();
        builder.readTimeout(10, TimeUnit.SECONDS);
        builder.connectTimeout(5, TimeUnit.SECONDS);

        builder.addInterceptor(this);

        return builder.build();
    }

    private String getHash(long timestamp) {
        return HashConverter.toMD5(timestamp + PRIVATE_KEY + API_KEY);
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();
        long timestamp = Calendar.getInstance().getTimeInMillis();
        HttpUrl url = originalHttpUrl.newBuilder().addQueryParameter(API_KEY_NAME, API_KEY)
                .addQueryParameter(TIME_STAMP_NAME, String.valueOf(timestamp))
                .addQueryParameter(HASH_NAME, getHash(timestamp))
                .build();

        Request.Builder requestBuilder = original.newBuilder().url(url);
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}
