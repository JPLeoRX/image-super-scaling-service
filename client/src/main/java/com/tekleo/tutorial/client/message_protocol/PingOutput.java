package com.tekleo.tutorial.client.message_protocol;

import com.tekleo.tutorial.client.JsonSerializable;
import lombok.*;

@Getter @AllArgsConstructor @NoArgsConstructor @ToString @EqualsAndHashCode
public class PingOutput implements JsonSerializable {
    private boolean success;
}