package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.Main;
import org.junit.Assert;
import org.junit.Test;

public class MainTests {

    private Main VALID_MAIN = new Main.Builder(new Main()).build();

    @Test
    public void mainCouldNotBeNull() {
        Assert.assertNotNull(VALID_MAIN);
    }

}
