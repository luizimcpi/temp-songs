package com.devlhse.tempsongs.service;

import com.devlhse.tempsongs.dto.City;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(url="https://samples.openweathermap.org/data/2.5/", name = "cities")
public interface CityClient {

    @GetMapping("weather?q={cityName}&appid=b6907d289e10d714a6e88b30761fae22")
    City getCityInfoByName(@RequestParam("cityName") String cityName);
}
