package org.example;

import okhttp3.*;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Request request = new Request.Builder().url("https://www.google.com/").build();
        Call call = new OkHttpClient().newCall(request);
        Response response = call.execute();

        System.out.println(response.body().string());
    }
}
