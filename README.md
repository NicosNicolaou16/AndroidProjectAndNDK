# Android Project and NDK (Kotlin)

[![Linktree](https://img.shields.io/badge/linktree-1de9b6?style=for-the-badge&logo=linktree&logoColor=white)](https://linktr.ee/nicos_nicolaou)
[![Site](https://img.shields.io/badge/Site-blue?style=for-the-badge&label=Web)](https://nicosnicolaou16.github.io/)
[![X](https://img.shields.io/badge/X-%23000000.svg?style=for-the-badge&logo=X&logoColor=white)](https://twitter.com/nicolaou_nicos)
[![LinkedIn](https://img.shields.io/badge/linkedin-%230077B5.svg?style=for-the-badge&logo=linkedin&logoColor=white)](https://linkedin.com/in/nicos-nicolaou-a16720aa)
[![Medium](https://img.shields.io/badge/Medium-12100E?style=for-the-badge&logo=medium&logoColor=white)](https://medium.com/@nicosnicolaou)
[![Mastodon](https://img.shields.io/badge/-MASTODON-%232B90D9?style=for-the-badge&logo=mastodon&logoColor=white)](https://androiddev.social/@nicolaou_nicos)
[![Bluesky](https://img.shields.io/badge/Bluesky-0285FF?style=for-the-badge&logo=Bluesky&logoColor=white)](https://bsky.app/profile/nicolaounicos.bsky.social)
[![Dev.to blog](https://img.shields.io/badge/dev.to-0A0A0A?style=for-the-badge&logo=dev.to&logoColor=white)](https://dev.to/nicosnicolaou16)
[![YouTube](https://img.shields.io/badge/YouTube-%23FF0000.svg?style=for-the-badge&logo=YouTube&logoColor=white)](https://www.youtube.com/@nicosnicolaou16)
[![Google Developer Profile](https://img.shields.io/badge/Developer_Profile-blue?style=for-the-badge&label=Google)](https://g.dev/nicolaou_nicos)

A guide and starter project for setting up the **Android NDK (Native Development Kit)** to facilitate communication between Kotlin/Java and C/C++ code. This project demonstrates a basic implementation where a C++ backend returns a string to be displayed in the Android UI.

> [!IMPORTANT]  
> A detailed step-by-step guide is available on Medium!  
> 👉 **[NDK Setup on Android/Flutter Android Project](https://medium.com/@nicosnicolaou/ndk-setup-on-android-flutter-android-project-1571d9a3f5cb)** 👈

> [!IMPORTANT]  
> A similar project is also available for Flutter (Dart)!  
> 👉 **[FlutterAndroidProjectAndNDK](https://github.com/NicosNicolaou16/FlutterAndroidProjectAndNDK)** 👈

## 🚀 Setup Steps

### 1. Requirements
* Install the latest **NDK** and **CMake** via the Android Studio SDK Manager (**SDK Tools** tab).

### 2. Native Configuration
* Create a `cpp` package under `src/main/`.
* Add your `.cpp` source file and a `CMakeLists.txt` file.

**Example `CMakeLists.txt`:**

```cmake
# For more information about using CMake with Android Studio, read the
# documentation: https://d.android.com/studio/projects/add-native-code.html

# Sets the minimum version of CMake required to build the native library.

cmake_minimum_required(VERSION 3.10.0)

# Need the project name
project(AndroidAndNDK)

# Creates and names a library, sets it as either STATIC
# or SHARED, and provides the relative paths to its source code.
# You can define multiple libraries, and CMake builds them for you.
# Gradle automatically packages shared libraries with your APK.

add_library( # Sets the name of the library.
        message # based on .cpp file name

        # Sets the library as a shared library.
        SHARED

        # Provides a relative path to your source file(s).
        message.cpp) # based on .cpp file name

# Searches for a specified prebuilt library and stores the path as a
# variable. Because CMake includes system libraries in the search path by
# default, you only need to specify the name of the public NDK library
# you want to add. CMake verifies that the library exists before
# completing its build.

find_library( # Sets the name of the path variable.
        log-lib

        # Specifies the name of the NDK library that
        # you want CMake to locate.
        log)

# Specifies libraries CMake should link to your target library. You
# can link multiple libraries, such as libraries you define in this
# build script, prebuilt third-party libraries, or system libraries.

target_link_libraries( # Specifies the target library.
        message # based on .cpp file name

        # Links the target library to the log library
        # included in the NDK.
        ${log-lib})
```

### 3. Gradle Integration
Add the following to your module-level `build.gradle.kts`:

```Kotlin
android {

    //Other Gradle Code Here...

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "4.1.2"
        }
    }
    ndkVersion = "30.0.16248370"

    //Other Gradle Code Here...
}
```

### 4. Implementation (Kotlin)
Load the library and declare the external function:

```Kotlin
companion object {
    /**
     * Load the C file
     * */
    init {
        System.loadLibrary("message")
    }
}
```

- Initialize the method(s) from .cpp file.

```Kotlin
private external fun message(): String 
```

## 🔧 Versioning

- **Target SDK:** **37**
- **Minimum SDK:** **29**
- **Kotlin Version:** **2.4.20**
- **Gradle Version:** **9.4.0**
- **Native Build Tool:** **CMake 3.1.2+**
- **NDK Version:** **30.0.16248370**
- **CMake Version:** **4.1.2**

## 📚 References & Tutorials

- **Official Samples:** [android/ndk-samples](https://github.com/android/ndk-samples)
- **Documentation:** [Add native code to your project](https://developer.android.com/studio/projects/add-native-code)
- **Community Guide:** [Getting Started with Android NDK - Mindorks](https://blog.mindorks.com/getting-started-with-android-ndk-android-tutorial/)

## ⭐ Stargazers

If you enjoy this project, please give it a star!
Check out all the stargazers
here: [Stargazers on GitHub](https://github.com/NicosNicolaou16/AndroidProjectAndNDK/stargazers)

## 🙏 Support & Contributions

This project is actively maintained. Feedback, bug reports, and feature requests are welcome! Please feel free to **open an issue** or submit a **pull request**.