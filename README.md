# NexoMusic 🎵

A modern Android Music Player application built with **Kotlin and XML**, designed to provide a smooth and immersive music-listening experience. The app integrates music search, album artwork, and background audio playback using **AndroidX Media3**.

## ✨ Features

* 🎵 **Music Search**
  Search for songs, artists, and albums through the integrated music API.

* ▶️ **Music Playback**
  Play and control songs directly from the application.

* 🔊 **Background Playback**
  Music can continue playing while the app is running in the background using **Media3 MediaSessionService**.

* 🎧 **Mini Player**
  Quickly access the currently playing song and basic playback controls while browsing the app.

* 📱 **Full-Screen Music Player**
  Dedicated player screen with album artwork, playback controls, and song progress.

* 🌙 **Modern Dark UI**
  Clean and visually focused music-player interface designed using Android XML layouts.

* 🖼️ **Album Artwork**
  Dynamically loads music artwork for a better visual experience.

* 🌐 **API Integration**
  Fetches music-related data from the Deezer music API.

## 🛠️ Tech Stack

| Technology              | Usage                          |
| ----------------------- | ------------------------------ |
| **Kotlin**              | Application development        |
| **XML**                 | UI development                 |
| **Android SDK**         | Android application framework  |
| **AndroidX Media3**     | Music playback & media session |
| **MediaSessionService** | Background playback            |
| **Retrofit**            | API/network communication      |
| **Gson**                | JSON parsing                   |
| **Coil**                | Image loading                  |
| **MVVM**                | Application architecture       |

## 🏗️ Architecture

NexoMusic follows the **MVVM (Model–View–ViewModel)** architecture to keep UI, business logic, and data handling separated.

```text
UI (XML)
   │
   ▼
ViewModel
   │
   ▼
Repository / API
   │
   ▼
Retrofit
   │
   ▼
Music API
```

For audio playback:

```text
UI
 │
 ▼
MediaController
 │
 ▼
MediaSessionService
 │
 ▼
Media3 / ExoPlayer
 │
 ▼
Audio Playback
```

## 🎧 Music Playback

The application uses **AndroidX Media3** for audio playback.

`MediaSessionService` allows the player to continue working when the application moves into the background or the device screen is locked.

The playback system provides controls such as:

* Play
* Pause
* Previous
* Next
* Seek
* Progress tracking
* Background playback

## 🌐 API Integration

NexoMusic retrieves music information through a music API using **Retrofit**.

The networking layer is responsible for retrieving information such as:

* Song title
* Artist information
* Album information
* Album artwork
* Audio/playback information

The received JSON response is converted into Kotlin data models using **Gson**.

## 🖼️ Image Loading

**Coil** is used to efficiently load and display album artwork received from the API.

This helps provide smooth image loading while browsing songs and displaying the currently playing track.

## 📂 Project Structure

A simplified structure of the application:

```text
NexoMusic/
│
├── app/
│   └── src/
│       └── main/
│           ├── java/
│           │   └── com/example/...
│           │
│           ├── res/
│           │   ├── drawable/
│           │   ├── layout/
│           │   ├── mipmap/
│           │   └── values/
│           │
│           └── AndroidManifest.xml
│
├── build.gradle
├── settings.gradle
└── README.md
```

## 🚀 Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/Aman-Kumar-Goswami/NexoMusic.git
```

### 2. Open in Android Studio

Open the cloned project in **Android Studio** and allow Gradle to sync the project.

### 3. Configure API

Configure the required API credentials according to the project's API configuration.

> **Note:** API keys should ideally be stored securely using `local.properties`, `BuildConfig`, or another secure configuration method instead of committing them directly to the repository.

### 4. Run the Application

Connect an Android device or start an Android Emulator and run the application from Android Studio.

## 🔮 Future Improvements

* 🔐 User authentication
* ❤️ Favorite songs
* 📋 Custom playlists
* 📥 Offline music support
* 🎚️ Equalizer and audio effects
* 🔔 Improved notification controls
* 📊 Listening history
* 🎵 Recently played songs

## 📚 What I Learned

While developing NexoMusic, I worked with:

* Android XML UI development
* Kotlin
* MVVM architecture
* Retrofit API integration
* JSON parsing with Gson
* Image loading with Coil
* AndroidX Media3
* ExoPlayer
* MediaSessionService
* Background audio playback
* Android activity/service communication
---

⭐ If you find this project useful, consider giving it a star!
