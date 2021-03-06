package com.zzh.util.util;

import lombok.experimental.UtilityClass;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

import java.io.IOException;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author zhihao zhang
 * @since 2020.03.22
 */

@UtilityClass
public class NetUtil {
    private static final MediaType JSON = MediaType.get("application/json; charset=utf-8");
    private static final long SIXTY_SECONDS = 60000;
    private static final OkHttpClient HTTP_CLIENT = new OkHttpClient.Builder()
            .readTimeout(SIXTY_SECONDS, TimeUnit.MILLISECONDS)
            .writeTimeout(SIXTY_SECONDS, TimeUnit.MILLISECONDS)
            .build();

    public static String getRequest(String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            return getResponseResult(response);
        }
    }

    public static String postRequest(String url, String json) throws IOException {
        RequestBody body = RequestBody.create(json, JSON);
        Request request = new Request.Builder()
                .url(url)
                .post(body)
                .build();
        try (Response response = HTTP_CLIENT.newCall(request).execute()) {
            return getResponseResult(response);
        }
    }

    private static String getResponseResult(Response response) throws IOException {
        ResponseBody body = response.body();
        if (Objects.isNull(body)) {
            return "";
        }
        return body.string();
    }
}
