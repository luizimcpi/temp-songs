package com.devlhse.tempsongs.dto.track;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "external_urls",
        "name"
})
public class Track {

    @JsonProperty("external_urls")
    private ExternalUrls externalUrls;

    @JsonProperty("name")
    private String name;


    @JsonProperty("external_urls")
    public ExternalUrls getExternalUrls() {
        return externalUrls;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }
}
