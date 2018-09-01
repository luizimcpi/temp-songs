package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.Coord;
import org.junit.Assert;
import org.junit.Test;

public class CoordTests {

    private Coord VALID_COORD = new Coord.Builder(new Coord()).build();

    @Test
    public void coordCouldNotBeNull() {
        Assert.assertNotNull(VALID_COORD);
    }
}
