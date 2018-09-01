package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.City;
import org.junit.Assert;
import org.junit.Test;

public class CityTests {
    private City VALID_CITY = new City.Builder(new City()).build();

    @Test
    public void cityCouldNotBeNull() {
        Assert.assertNotNull(VALID_CITY);
    }
}
