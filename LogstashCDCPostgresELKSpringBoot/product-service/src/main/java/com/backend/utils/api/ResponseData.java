package com.backend.utils.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData<T> {

    @JsonProperty("entity_name")
    private String entityName;

    @JsonProperty("message")
    private String message;

    @JsonProperty("status")
    private int status;

    @JsonProperty("timestamp")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Ho_Chi_Minh")
    private Instant timestamp = Instant.now();

    @JsonProperty("data")
    private T data;

    public ResponseData(int status, T data) {
        super();
        this.status = status;
        this.data = data;
    }

}
