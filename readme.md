# Kotlin based Clean Architecture in Android

### Sample Screenshot
![Screenshot](screenshot-v1.png?raw=true "Screenshot")

Clean Android Architecture Sample App 
  - Module based app [domain, data, presentation, ui]
  - Android Architecture Components
  - Dagger 2.16
  - Room
  - Retrofit
  - Glide
  - AndroidX

# Installation

  - Clone the repo and open it in Android Studio 3.3 or above
  - Create a file `secret_keys.gradle` at root lavel. i.e. same folder as `dependencies.gradle`
  - Go to [https://www.themoviedb.org/](https://www.themoviedb.org/) for getting API Key 
  - The content of the `secret_keys.gradle` would be 
   ```sh
 ext {
    tmdb_api_key = "<YOUR_API_KEY_FROM_TMDB>"
}
```


