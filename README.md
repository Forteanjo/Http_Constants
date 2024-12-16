# HTTP Constants Lister - Android App

[![License](https://img.shields.io/badge/License-MIT-blue.svg)](https://opensource.org/licenses/MIT)
[![Kotlin](https://img.shields.io/badge/Kotlin-1.9.20-blue.svg)](https://kotlinlang.org/)
[![Compose](https://img.shields.io/badge/Compose-1.5.4-blue.svg)](https://developer.android.com/jetpack/compose)
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

This Android application provides a simple and convenient way to browse common HTTP headers and status codes. It's built using Jetpack Compose, the modern UI toolkit for Android.

## Table of Contents

-   [Features](#features)
-   [Getting Started](#getting-started)
    -   [Prerequisites](#prerequisites)
    -   [Installation](#installation)
-   [Usage](#usage)
-   [Code Structure](#code-structure)
-   [Dependencies](#dependencies)
-   [Contributing](#contributing)
-   [License](#license)
-   [Contact](#contact)
- [Project Link](#project-link)

## Features

-   **Browse HTTP Headers:** View a list of common HTTP headers and their descriptions.
-   **Browse HTTP Status Codes:** View a list of common HTTP status codes and their meanings.
-   **Clean and Simple UI:** The app uses a clean and intuitive user interface built with Jetpack Compose.
-   **Efficient List Rendering:** The app uses `LazyColumn` for efficient rendering of long lists.
-   **Well-Organized Code:** The code is well-structured and easy to understand, making it a good example for learning Jetpack Compose and Android development.
- **Clear Visual Hierarchy:** The app uses `SectionHeader` and `ListItem` composables to create a clear visual hierarchy.
- **Material Design:** The app uses Material Design components.

## Getting Started

### Prerequisites

-   Android Studio (latest version recommended)
-   Android SDK (API level 21 or higher)
-   Basic knowledge of Kotlin and Jetpack Compose

### Installation

1.  **Clone the repository:**
2. 2.  **Open in Android Studio:**

    -   Open Android Studio and select "Open an existing Android Studio project."
    -   Navigate to the cloned repository directory and select it.

3.  **Build and Run:**

    -   Connect an Android device or start an emulator.
    -   Click the "Run" button in Android Studio.

## Usage

1.  Launch the app on your Android device or emulator.
2.  The main screen will display two sections: "HTTP Headers" and "HTTP Status Codes."
3.  Scroll through the lists to browse the headers and status codes.
4. Each item in the list shows the name and the value.

## Code Structure

-   **`MainActivity.kt`:** The main entry point of the application.
-   **`HttpListerScreen.kt`:** Contains the `HttpListerScreen` composable, which displays the list of HTTP headers and status codes.
-   **`HttpHeaders.kt`:** Defines the `HttpHeaders` class, which provides constants for common HTTP header names.
-   **`HttpStatus.kt`:** Defines the `HttpStatus` class, which provides constants for common HTTP status codes.
- **`SectionHeader.kt`**: Defines the `SectionHeader` composable.
- **`LabeledValueRow.kt`**: Defines the `LabeledValueRow` composable.

## Dependencies

-   **Jetpack Compose:**
    - `androidx.compose.ui:ui`
    - `androidx.compose.material3:material3`
    - `androidx.compose.ui:ui-tooling-preview`
    - `androidx.compose.foundation:foundation`
    - `androidx.compose.foundation:foundation-layout`
    - `androidx.compose.foundation:foundation-android`
    - `androidx.compose.ui:ui-android`
    - `androidx.compose.ui:ui-text-android`
    - `androidx.compose.ui:ui-util-android`
    - `androidx.compose.ui:ui-geometry-android`
    - `androidx.compose.ui:ui-graphics-android`
    - `androidx.compose.ui:ui-unit-android`
    - `androidx.compose.runtime:runtime-android`
    - `androidx.compose.runtime:runtime-saveable-android`
    - `androidx.compose.material:material-icons-core-android`
    - `androidx.compose.material:material-ripple-android`
    - `androidx.compose.material:material-icons-extended-android`
    - `androidx.compose.material3:material3-window-size-class-android`
    - `androidx.compose.animation:animation-android`
    - `androidx.compose.animation:animation-core-android`
-   **Android Core KTX:**
    - `androidx.core:core-ktx`
- **Activity Compose:**
    - `androidx.activity:activity-compose`
- **Lifecycle:**
    - `androidx.lifecycle:lifecycle-runtime-compose`
    - `androidx.lifecycle:lifecycle-viewmodel-compose`
- **Navigation Compose:**
    - `androidx.navigation:navigation-compose`

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please follow these steps:

1.  Fork the repository.
2.  Create a new branch for your feature or bug fix.
3.  Make your changes and commit them.
4.  Push your changes to your forked repository.
5.  Submit a pull request.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Contact

Donald McCaskey - [forteanjo@sky.com](mailto:forteanjo@sky.com)

## Project Link

[https://github.com/forteanjo/http-constants-lister](https://github.com/forteanjo/http-constants-lister)
