package com.tekleo.tutorial.client.message_protocol;

import com.tekleo.tutorial.client.JsonSerializable;
import lombok.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

@Getter @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class UpscaleInput implements JsonSerializable {
    private String imageBase64;

    public UpscaleInput(byte[] imageBytesArray) {
        this(Base64.getEncoder().encodeToString(imageBytesArray));
    }

    public UpscaleInput(File imageFile) throws IOException {
        this(Files.readAllBytes(imageFile.toPath()));
    }
}