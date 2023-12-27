# Android Project and NDK (Kotlin)

This project is just the setup for the NDK in android, the communication Android project with C/C++ file. In this
example we print only a text from C/C++ file to Android Project.

## Similar project with (Dart Language)
https://github.com/NicosNicolaou16/FlutterAndroidProjectAndNDK <br />

# Setup - Steps

- Install the latest NDK and CMake version from Android Studio SDK Manager from the SDK Tools
  section.
- Create the cpp package, add the CMake .txt and .cpp file.
- Add the follow code in Gradle file.

```Kotlin
android {

    //Other Gradle Code Here...

    externalNativeBuild {
        cmake {
            path = file("src/main/cpp/CMakeLists.txt")
            version = "3.22.1"
        }
    }
    ndkVersion = "26.1.10909125"

    //Other Gradle Code Here...
}
```

- Load the C/C++ file.

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

- Call the method(s) from .cpp file.

```Kotlin
private external fun message(): String 
```
# References/Tutorials Follow
https://blog.mindorks.com/getting-started-with-android-ndk-android-tutorial/ <br />
https://developer.android.com/studio/projects/add-native-code <br />
https://github.com/android/ndk-samples <br />

Target SDK version: 34 <br />
Minimum SDK version: 27 <br />
Kotlin version: 1.9.21 <br />
Gradle version: 8.2.0 <br />