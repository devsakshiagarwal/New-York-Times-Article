# New York Times Most Popular News Article App
Demo App for showing articles from new york time open source apis.

### Architecture Used
  - Single Activity Principle with Navigation Component
  - MVVM with Kotlin & Hilt for DI
  - Retrofit with Gson & Coroutines for Networking

### Libraries Used
 - [Navigation] - for fragment navigation 
 - [Lifecycle] - for viewmodels and observers
 - [Retrofit, Gson & Coroutines] - for networking
 - [Glide] - for image loading
 - [Hilt] - for Dependency Injection

### App Structure
- [arch] - has all the common and base classes for the app
- [model] - is responsible for everything related to data (api calls, schemas, repositories)
- [view] - is responsible for view classes (activity and fragments) along with viewmodels and adapters for listing