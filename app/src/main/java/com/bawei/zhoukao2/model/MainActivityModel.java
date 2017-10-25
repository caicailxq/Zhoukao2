package com.bawei.zhoukao2.model;

import android.util.Log;

import com.bawei.zhoukao2.LogInterceptor;
import com.bawei.zhoukao2.bean.Qbean;
import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/10/16.
 */

public class MainActivityModel {
    public void getData(boolean up, final MainActivityModelListener mainActivityModelListener){
        OkHttpClient builder = new OkHttpClient.Builder()
                .addInterceptor(new LogInterceptor())
                .addNetworkInterceptor(new LogInterceptor())
                .build();

        final Request request = new Request.Builder()
                .url("http://tingapi.ting.baidu.com/v1/restserver/ting?method=baidu.ting.billboard.billList&type=1&size=10&offset=0")
                .build();
        builder.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                mainActivityModelListener.callBackFailure(1);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String result = response.body().string();
                Gson gson=new Gson();
                Log.d("qqq",result);
               Qbean qbean = gson.fromJson(result, Qbean.class);
               mainActivityModelListener.callBackSuccess(qbean);
            }
        });
    }
}
