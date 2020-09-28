package com.tekleo.tutorial.client;

import lombok.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Getter @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class UpscaleOutput implements JsonSerializable {
    private String imageBase64;

    public byte[] toBytesArray() {
        return Base64.getDecoder().decode(imageBase64);
    }
}