package io.github.zanella.nomad.v1.agent.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor(suppressConstructorProperties = true)
public class Members {

    @JsonProperty("ServerName") String serverName;
    @JsonProperty("ServerRegion") String serverRegion;
    @JsonProperty("ServerDC") String serverDc;

    @JsonProperty("Members") List<Self.Member> member;
}
