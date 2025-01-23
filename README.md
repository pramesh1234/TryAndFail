
The project follows Clean Architecture principles, incorporating ViewModel for state management, Hilt for dependency injection, Jetpack Compose for UI implementation, and Retrofit for networking. It consists of two primary screens:

Home Screen
This screen displays a list of anime, including their name, image, and rating. A LazyColumn is used to populate the list with data retrieved from an API call.

Detail Screen
This screen presents detailed information about the anime selected by the user on the Home Screen. Although the detail includes a YouTube embedded URL, it is not supported by the native ExoPlayer. While creating a custom player is under consideration, it will take time. For now, the screen displays the anime's poster image.
