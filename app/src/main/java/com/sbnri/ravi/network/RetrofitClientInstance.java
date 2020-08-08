package com.sbnri.ravi.network;

import android.app.Application;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.NetworkRequest;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClientInstance {
    private static Retrofit retrofit;
    private static final String BASE_URL = "https://api.github.com/orgs/octokit/";

    public static Retrofit getInstance(Application application){
        if(retrofit == null){
            long cacheSize = 5 * 1024 * 1024;
            Cache myCache = new Cache(application.getCacheDir(), cacheSize);

            OkHttpClient okHttpClient = new OkHttpClient.Builder()
                    .cache(myCache)
                    .addInterceptor(chain -> {
                        Request request = chain.request();
                        Request.Builder builder = request.newBuilder();
//                            if(hasNetworkConnectivity(application))
                        builder.header("Cache-Control", "public, max-age=" + 5);
//                            else
//                                builder.header("Cache-Control", "public, only-if-cached, max-stale=" + 60 * 60 * 24 * 7);
                        request = builder.build();
                        return chain.proceed(request);
                    })
                    .build();

            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    private static Boolean hasNetworkConnectivity(Application application){

        boolean isConnected = false; // Initial Value
        ConnectivityManager connectivityManager = (ConnectivityManager) application.getSystemService(Context.CONNECTIVITY_SERVICE);
        Network activeNetwork = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            activeNetwork = connectivityManager.getActiveNetwork();
        }
        if (activeNetwork != null )
            isConnected = true;
        return isConnected;
    }
}
