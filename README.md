# Popular Movie (stage 1)

## Overview
This is a project of Udacity Android Developer Nanodegree. The project is divided into 2 stages and this is the first stage of the project.
The app has functionality to show the users the most popular movies at the moment

## Running the app
This app uses the [Movie Database API](https://developers.themoviedb.org/). The API key needs to be obtianed from movieDB website and put in the build.gradel(Modul: app)

```gradle
buildTypes.each {
        it.buildConfigField 'String', 'THE_MOVIEDB_API_KEY', '"YOUR KEY"'
    }
 ```
 
 ## App functionalities 
 
* Display the grid view of movie posters.
* User can choose how to display the movies list based on sort order (by most popular or by highest-rated).
* Display additional information when the users tap on movie poster (Original titel, thumbnail of the movie, Synopsis of the movie, rating, and released date).

## App Preview

<p align="center">
 <img src="/images/popmoviestage1.png" width="40%"> <img src="/images/additional_info.png" width="40%">
  <img src="/images/setting.png" width="40%"> <img src="/images/sorting_dialog.png" width="40%">
</p>
