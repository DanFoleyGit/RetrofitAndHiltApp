This is intended as a quick start guide for creating a Hilt app using Retrofit

  <h2>1. build.gradle setup</h2>

  add following plugins

      id("kotlin-kapt")
      id("com.google.dagger.hilt.android")

  add the following dependencies

      implementation("com.google.dagger:hilt-android:2.51")
      kapt("com.google.dagger:hilt-android-compiler:2.51")

      implementation("com.squareup.retrofit2:retrofit:2.11.0")
      implementation("com.squareup.retrofit2:converter-gson:2.11.0")
      implementation("com.squareup.okhttp3:logging-interceptor:4.12.0")

  in project build.gradle add
      id("com.google.dagger.hilt.android") version "2.51" apply false

  <h2>2. add the the name to the AndroidManifest</h2>

      <application
          android:name=".MyRetroFitApplication"

  <h2>3. Create the application class for hilt</h2>

  <h2>5. create the retrofit instance (With interceptor)
      Good practice to store the base URL in a constant</h2>

  <h2>6. create the API needed for each request</h2>

  <h2>7. Provide the the retrofit in the retrofit module using hilt.</h2>

  <h2>8. create viewmodel, views usecase, repository and repository implementation</h2>

  <h2>9. provide the repository implementation for the repository and handle data in the repository Implementation</h2>
