package org.example;

import okhttp3.*;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Помилка передачі параметрів\nПотрібен один параметр");
            System.exit(0);
        }
        String url = args[0];
        System.out.println("Url from args  : " + url);
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                assert response.body() != null;
                String responseBody = response.body().string();
                System.out.println("Response : " + responseBody);
            } else {
                System.out.println("Request failed with HTTP error code " + response.code());
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
