# temp-songs

Build Status Branch Master

[![Build Status](https://travis-ci.org/luizimcpi/temp-songs.svg?branch=master)](https://travis-ci.org/luizimcpi/temp-songs)

This is a micro-service able to accept RESTful requests receiving as parameter either city name or lat long coordinates and returns a playlist (only track names)
suggestion according to the current temperature.

## Business rules

* If temperature (celcius) is above 30 degrees, suggest tracks for party
* In case temperature is between 15 and 30 degrees, suggest pop music tracks
* If it's a bit chilly (between 10 and 14 degrees), suggest rock music tracks
* Otherwise, if it's freezing outside, suggests classical music tracks 

## External API´s

It uses OpenWeatherMaps API (https://openweathermap.org) to fetch temperature data and Spotify (https://developer.spotify.com) to suggest the tracks as part of the playlist.

## How to run

In the root of this project run the following command

```
./gradlew bootRun
```

## Endpoints

City Weather Info

```
GET http://localhost:8080/cities/{city}/weather
```

City Songs according to weather
```
GET http://localhost:8080/cities/{city}/weather/songs
```

City Songs according to weather using coordinates
```
http://localhost:8080/cities/weather/songs?lat={value}&lon={value}
```