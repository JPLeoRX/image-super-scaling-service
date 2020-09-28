package com.tekleo.tutorial.client;

import com.tekleo.tutorial.client.message_protocol.PingOutput;
import com.tekleo.tutorial.client.message_protocol.UpscaleInput;
import com.tekleo.tutorial.client.message_protocol.UpscaleOutput;

public class Client {
    private static String BASE_URL = "http://localhost:7777";

    public static PingOutput ping() throws Exception {
        String url = BASE_URL + "/ping";
        String response = ClientUtils.doGet(url);
        return ClientUtils.parseJsonResponse(response, PingOutput.class);
    }

    public static UpscaleOutput upscale(UpscaleInput input) throws Exception {
        String url = BASE_URL + "/upscale";
        String response = ClientUtils.doPost(url, input.toJson());
        return ClientUtils.parseJsonResponse(response, UpscaleOutput.class);
    }
}