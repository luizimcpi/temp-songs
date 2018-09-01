package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.City;
import org.junit.Assert;
import org.junit.Test;

public class CityTests {
    private City VALID_CITY = new City.Builder(new City()).withDt(1).build();

    @Test
    public void dtFieldCouldNotBeNull() {
        Assert.assertNotNull(VALID_CITY.getDt());
    }
}
