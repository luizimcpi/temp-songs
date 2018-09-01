package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.Wind;
import org.junit.Assert;
import org.junit.Test;

public class WindTests {

    private Wind VALID_WIND = new Wind.Builder(new Wind()).build();

    @Test
    public void windCouldNotBeNull() {
        Assert.assertNotNull(VALID_WIND);
    }

}
