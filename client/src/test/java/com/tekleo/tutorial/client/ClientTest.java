package com.tekleo.tutorial.client;

import com.tekleo.tutorial.client.message_protocol.PingOutput;
import com.tekleo.tutorial.client.message_protocol.UpscaleInput;
import com.tekleo.tutorial.client.message_protocol.UpscaleOutput;
import org.apache.commons.io.FileUtils;
import org.junit.Ignore;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

@Ignore
public class ClientTest {
    @Test
    public void ping() throws Exception {
        PingOutput output = Client.ping();
        assertNotNull(output);
        assertTrue(output.isSuccess());
    }

    @Test
    public void upscale() throws Exception {
        String inputFilePath = "/Users/leo/tekleo/image-super-scaling-service/sample-images/t7.jpg";
        String outputFilePath = "/Users/leo/tekleo/image-super-scaling-service/sample-images/t7_up.jpg";
        File inputFile = new File(inputFilePath);
        UpscaleInput input = new UpscaleInput(inputFile);
        UpscaleOutput output = Client.upscale(input);
        File outputFile = new File(outputFilePath);
        FileUtils.writeByteArrayToFile(outputFile, output.toBytesArray());
    }
}