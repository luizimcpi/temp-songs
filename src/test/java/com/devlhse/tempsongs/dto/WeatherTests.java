package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.Weather;
import org.junit.Assert;
import org.junit.Test;

public class WeatherTests {

    private Weather VALID_WEATHER = new Weather.Builder(new Weather()).build();

    @Test
    public void weatherCouldNotBeNull() {
        Assert.assertNotNull(VALID_WEATHER);
    }

}
