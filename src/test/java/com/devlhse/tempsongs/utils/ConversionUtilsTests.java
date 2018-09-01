package com.devlhse.tempsongs.utils;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class ConversionUtilsTests {

    @Test
    public void shouldConvertTemperatureWithSuccess(){
        assertEquals(30.0, ConversionUtils.kelvinToCelsius(303.0));
    }
}
