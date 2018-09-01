package com.devlhse.tempsongs.dto.city;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "all"
})
public class Clouds {
    @JsonProperty("all")
    private Integer all;

    @JsonProperty("all")
    public Integer getAll() {
        return all;
    }

    public static class Builder {

        private Clouds cloudsToBuild;

        public Builder(final Clouds clouds) {

            cloudsToBuild = new Clouds();

            this.cloudsToBuild.all = clouds.getAll();
        }

        public Clouds.Builder withAll(final Integer all) {
            this.cloudsToBuild.all = all;
            return this;
        }

        public Clouds build() {
            final Clouds builtClouds = cloudsToBuild;
            cloudsToBuild = new Clouds();
            return builtClouds;
        }

    }
}
