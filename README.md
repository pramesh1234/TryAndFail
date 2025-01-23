## Project Overview

This project follows **Clean Architecture** principles and utilizes the following technologies:

- **ViewModel** for state management
- **Hilt** for dependency injection
- **Jetpack Compose** for UI implementation
- **Retrofit** for networking

The app consists of two main screens:

### Home Screen
The **Home Screen** displays a list of anime with their **name**, **image**, and **rating**. The list is populated using a **LazyColumn**, with data fetched from an API.

### Detail Screen
The **Detail Screen** shows detailed information about the anime selected on the **Home Screen**. Although a YouTube embedded URL is included, it isn't supported by the native **ExoPlayer**. A custom player will be implemented in the future, but currently, the screen shows the anime's **poster image**.
