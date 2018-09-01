package com.devlhse.tempsongs.controller;

import com.devlhse.tempsongs.dto.city.City;
import com.devlhse.tempsongs.dto.track.Playlist;
import com.devlhse.tempsongs.service.CityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class CityControllerTests {

    private static final String BASE_SEARCH_CITY_URL = "/cities/santos/weather/";
    private static final String BASE_SEARCH_CITY_SONGS_URL = "/cities/santos/weather/songs";

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CityService cityService;

    @Test
    public void testGetCityWeatherWithSuccess() throws Exception {
        BDDMockito.given(this.cityService.getCityWeather(Mockito.anyString())).willReturn(new City());

        mvc.perform(MockMvcRequestBuilders.get(BASE_SEARCH_CITY_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCitySongsByWeatherWithSuccess() throws Exception {
        BDDMockito.given(this.cityService.getCitySongsByWeather(Mockito.anyString())).willReturn(new Playlist());

        mvc.perform(MockMvcRequestBuilders.get(BASE_SEARCH_CITY_SONGS_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetCitySongsByWeatherAndCoordinatesWithSuccess() throws Exception {
        BDDMockito.given(this.cityService.getCitySongsByWeatherByCoordinates(Mockito.anyString(), Mockito.anyString())).willReturn(new Playlist());

        mvc.perform(MockMvcRequestBuilders.get(BASE_SEARCH_CITY_SONGS_URL)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
