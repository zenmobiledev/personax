## Technology Used / Tech Stack

[![JDK](https://img.shields.io/badge/openjdk-21.0.5-437291?style=for-the-badge&logo=openJdk&logoColor=white)](https://openjdk.org/)
[![Android Studio](https://img.shields.io/badge/Android_Studio-2024.3.1_Meerkat-3DDC84?style=for-the-badge&logo=android-studio&logoColor=white)](https://developer.android.com/studio)
![Android Gradle Plugin](https://img.shields.io/badge/Android_Gradle_Plugin-8.9.0-3DDC84?style=for-the-badge&logo=android&logoColor=white)
[![Kotlin](https://img.shields.io/badge/Kotlin-2.0.21-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](http://kotlinlang.org)
[![KSP](https://img.shields.io/badge/KSP-2.0.21--1.0.26-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)](https://github.com/google/ksp)
[![Gradle](https://img.shields.io/badge/gradle-8.11.1-02303A?style=for-the-badge&logo=gradle&logoColor=white)](https://developer.android.com/studio/releases/gradle-plugin)
[![Hilt](https://img.shields.io/badge/hilt-2.51.1-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/training/dependency-injection/hilt-android)
[![Navigation](https://img.shields.io/badge/Navigation-2.7.5-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/jetpack/androidx/releases/navigation)
[![lifecycle](https://img.shields.io/badge/Lifecycle-2.8.7-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/jetpack/androidx/releases/lifecycle)
[![retrofit](https://img.shields.io/badge/Retrofit-2.11.0-000000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/square/retrofit)
[![Gson Converter](https://img.shields.io/badge/Converter_Gson-2.11.0-000000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/square/retrofit/blob/trunk/retrofit-converters/gson/README.md)
[![Logging Interceptor](https://img.shields.io/badge/Logging_Interceptor-4.12.0-000000?style=for-the-badge&logo=github&logoColor=white)](https://github.com/square/okhttp/tree/master/okhttp-logging-interceptor)
[![Data Store](https://img.shields.io/badge/Data_Store_Preference-1.1.2-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/jetpack/androidx/releases/datastore)
[![Room Database](https://img.shields.io/badge/Room_Database-2.6.1-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/jetpack/androidx/releases/room)
[![Splash Screen](https://img.shields.io/badge/Splash_Screen-1.0.1-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/develop/ui/views/launch/splash-screen)
[![Glide](https://img.shields.io/badge/Glide-4.16.0-000000?style=for-the-badge&logo=github&logoColor=white)](https://coil-kt.github.io/coil/)
[![View Pager 2](https://img.shields.io/badge/View_Pager_2-1.1.0-3DDC84?style=for-the-badge&logo=android&logoColor=white)](https://developer.android.com/jetpack/androidx/releases/viewpager2)

## Table of Contents

- [Technology Used / Tech Stack](#technology-used--tech-stack)
- [Preview](#preview)
- [Demo](#demo)
- [Features](#features)
- [Installation (How to run the project)](#installation-how-to-run-the-project)
- [Tree / Folder Structure](#tree--folder-structure)
- [Architecture](#architecture)
- [Design Pattern](#design-pattern)
- [Todos](#todos)
- [Done](#done)
- [Bugs](#bugs)
- [Credit / Contributor(s)](#credit--contributors)


## Preview
| App Introduction                            |
|---------------------------------------------|
| ![App Introduction](assets/preview_app.png) |

## Demo


## Features
- **Halaman Login**
>- Menyimpan status login menggunakan DataStore Preference
>- Tombol Logout yang menghapus status login

- **Halaman List User**
>- Menampilkan daftar user dalam bentuk Grid Layout
>- Setiap item menampilkan foto profil, nama dan email
>- tombol untuk menambahkan user ke daftar favorit

- **Halaman Detail User**
>- Menampilkan informasi data user
>- Menampilkan lokasi berdasarkan koordinat alamat
>- Tombol untuk melakukan panggilan telepon atau mengirim email

- **Halaman Favorite User**
>- Menampilkan daftar user favorit yang tersimpan di penyimpanan lokal
>- Opsi untuk menghapus user daftar favorit

## Installation (How to run the project)

To run the project locally, follow these steps:

### 1. Clone the repository

>- ```https://github.com/zenmobiledev/personax.git```
>- ```cd personax```

### 2. Open the project

>- Launch your preferred Integrated Development Environment (IDE), such as Android Studio or
   IntelliJ IDEA. Then, open the ```personax``` project directory within the IDE.

### 3. Build the project

Ensure that all necessary dependencies are installed. In Android Studio or IntelliJ IDEA, you can
typically do this by:

>- **Syncing the Project**: The IDE should automatically prompt you to sync the project with the
   Gradle files. If not, you can manually sync by clicking on the "Sync Project with Gradle Files"
   button.
>- **Building the Project:** Navigate to the ```Build``` menu and select ```Build Project```. This
   process will compile the code and prepare the application for running.

### 4. Run the application

After the build process completes successfully:

>- **Select a Device**: Choose an emulator or a physical device connected to your computer where
   you want to run the application.

>- **Launch the App**: Click on the green 'Run' button (usually depicted as a play icon) in the IDE
   toolbar, or navigate to ```Run``` > ```Run 'app'```. This action will install and start the
   application on the selected device.

## Tree / Folder Structure

```

```

## Architecture

| Architecture                             |
|------------------------------------------|
| ![Architecture](assets/architecture.png) |

## Design Pattern

>- Clean Architecture Pattern: Data Layer, Domain Layer, Presentation Layer
>- Repository Pattern
>- Dependency Injection Pattern
>- Use Case Pattern
>- MVVM (Model-View-ViewModel) Pattern
>- Adapter Pattern
>- Data Source Pattern
>- DAO (Data Access Object) Pattern
>- Factory Pattern
>- Observer Pattern
>- Mapper Pattern
>- Singleton Pattern

## Todos

>- [ ] Unit Testing
>- [ ] Implementasi fitur pencarian user dan filter user
>- [ ] Implementasi DataStore Preference untuk Dark Mode
>- [ ] Fitur share informasi user

## Done

**Point Penilaian**:
>- [x] Menggunakan Retrofit untuk mengambil data dari API
>- [x] Menggunakan Room Database untuk menyimpan data favorite user
>- [x] Implementasi DataStore Preference untuk manajemen sesi login
>- [x] Menggunakan MVVM Architecture
>- [x] Menerapkan Navigation Component untuk navigasi antar halaman
>- [x] Menggunakan Hilt untuk dependency injection

## Bugs
:exclamation: **UNKNOWN**

## Credit / Contributor(s)

- [Zaenal Arif](https://github.com/zenmobiledev)

