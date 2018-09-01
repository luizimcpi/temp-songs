package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.Coord;
import org.junit.Assert;
import org.junit.Test;

public class CoordTests {

    private Coord VALID_COORD = new Coord.Builder(new Coord()).withLat(1.0).withLon(1.0).build();

    @Test
    public void coordLatFieldCouldNotBeNull() {
        Assert.assertNotNull(VALID_COORD.getLat());
    }

    @Test
    public void coordLonFieldCouldNotBeNull() {
        Assert.assertNotNull(VALID_COORD.getLon());
    }
}
