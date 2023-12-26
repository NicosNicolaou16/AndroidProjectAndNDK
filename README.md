# Android Project and NDK (Kotlin)

This project is just the setup for NDK, the communication Android project with C/C++ file. In this
example we print only a text.

#Setup - Steps

- Install the latest NDK and CMake version from Android Studio SDK Manager from the SDK Tools
  section
- Create the cpp package, include the CMake .txt and .cpp file
- Add the follow code in Gradle file

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

- Load the C/C++ file

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

- Call the method(s) from .cpp file

```Kotlin
private external fun message(): String 
```