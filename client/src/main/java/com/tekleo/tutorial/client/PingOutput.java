package com.tekleo.tutorial.client;

import lombok.*;

@Getter @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class PingOutput implements JsonSerializable {
    private boolean success;
}