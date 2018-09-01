package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.Clouds;
import org.junit.Assert;
import org.junit.Test;

public class CloudsTests {

    private Clouds VALID_CLOUDS = new Clouds.Builder(new Clouds()).withAll(1).build();

    @Test
    public void cloudsFieldsAllCouldNotBeNull() {
        Assert.assertNotNull(VALID_CLOUDS.getAll());
    }
}
