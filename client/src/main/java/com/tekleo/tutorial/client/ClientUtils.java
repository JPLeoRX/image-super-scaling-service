package com.tekleo.tutorial.client;

import com.google.gson.GsonBuilder;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.lang.reflect.Type;

public class ClientUtils {
    private static String getJsonResponse(HttpResponse httpResponse) throws Exception {
        if (httpResponse.getStatusLine().getStatusCode() == 200) {
            HttpEntity httpEntity = httpResponse.getEntity();
            return EntityUtils.toString(httpEntity);
        } else {
            throw new IllegalStateException("Http response status code is invalid: " + httpResponse.getStatusLine().getStatusCode() + ", " + EntityUtils.toString(httpResponse.getEntity()));
        }
    }

    public static <M> M parseJsonResponse(String jsonResponse, Type responseResultType) throws Exception {
        return new GsonBuilder().create().fromJson(jsonResponse, responseResultType);
    }

    public static String doGet(String url) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(url);
        httpGet.setHeader("Accept", "application/json");
        return getJsonResponse(httpClient.execute(httpGet));
    }

    public static String doPost(String url, String jsonPayload) throws Exception {
        HttpClient httpClient = HttpClientBuilder.create().build();
        HttpPost httpPost = new HttpPost(url);
        httpPost.setEntity(new StringEntity(jsonPayload, ContentType.APPLICATION_JSON));
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");
        return getJsonResponse(httpClient.execute(httpPost));
    }
}