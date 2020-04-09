# Music
Music rebels

![Music rebels](https://github.com/eveey/Music/blob/master/app/src/main/assets/web_hi_res_round_512.png)

Sample Android app in [Kotlin](https://kotlinlang.org/) for searching artists on [Spotify](https://www.spotify.com/).

## Building the app
* [Gradle](https://gradle.org/) build system
* Requires [Java 8](https://java.com/en/download/faq/java8.xml)

Important note: to use the services you need to register on [Spotify Developer Console](https://developer.spotify.com/console/) in order to obtain client secrets and add them to the project local.properties file:

 clientID="<your_client_id>"
 
 scheme="<your_scheme>"
 
 host="<your_host>"
 
## Authentication
* Using [Spotify Android SDK](https://github.com/spotify/android-sdk) for authentication and artist search. For using the app you need to login or sign up for a Spotify account.

## Architecture
* MVVM (Model-View-ViewModel)
* [Android Arhitecture Components](https://developer.android.com/topic/libraries/architecture/)
* [LiveData](https://developer.android.com/reference/android/arch/lifecycle/LiveData)
* [RxKotlin](https://github.com/ReactiveX/RxKotlin)
* [RxRelay](https://github.com/JakeWharton/RxRelay)

## Dependency management
* [Google/Dagger](https://github.com/google/dagger) - Dependency injection

## Network
* [Square/Retrofit](https://github.com/square/retrofit) - HTTP RESTful connections
* [OkHttp 3](https://square.github.io/okhttp/3.x/okhttp/) - HTTP client
* [Square/Moshi](https://github.com/square/moshi) - Network JSON deserializer

## Unit tests
* [JUnit4](https://