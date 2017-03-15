package io.github.zanella.nomad.v1.client.models;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class LogStream {

    @JsonProperty("File") String file;

    @JsonProperty("Offset") Double offset;

    @JsonProperty("Data") String data;

    @JsonProperty("FileEvent") String fileEvent;

    public enum Type {

        stdout, stderr;
    }

    public enum Origin {

        start, end;
    }
}
