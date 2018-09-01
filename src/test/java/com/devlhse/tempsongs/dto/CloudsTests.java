package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.Clouds;
import org.junit.Assert;
import org.junit.Test;

public class CloudsTests {

    private Clouds VALID_CLOUDS = new Clouds.Builder(new Clouds()).build();

    @Test
    public void cloudsCouldNotBeNull() {
        Assert.assertNotNull(VALID_CLOUDS);
    }
}
