package com.devlhse.tempsongs.dto;

import com.devlhse.tempsongs.dto.city.Sys;
import org.junit.Assert;
import org.junit.Test;

public class SysTests {

    private Sys VALID_SYS = new Sys.Builder(new Sys()).build();

    @Test
    public void sysCouldNotBeNull() {
        Assert.assertNotNull(VALID_SYS);
    }

}
