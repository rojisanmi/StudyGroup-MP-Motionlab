# Navigation dan Routing di Jetpack Compose

Navigasi adalah proses perpindahan antar layar (composable) dalam aplikasi. Dengan Jetpack Compose, navigasi menjadi lebih sederhana melalui library `Navigation`. Sementara itu, routing mengacu pada pengelolaan jalur layar serta pengoperan data antar layar.

## Komponen Utama Navigasi
1. **NavHost**  
   Komponen utama yang mendefinisikan navigasi dalam aplikasi. Semua layar dan rute dijabarkan di sini.
   - **Fungsi Utama:**
     - Struktur navigasi aplikasi.
     - Mendefinisikan rute dan relasi antar layar.
   - **Contoh Kode:**
     ```kotlin
     val navController = rememberNavController()
     NavHost(navController = navController, startDestination = "home") {
         composable("home") { HomeScreen(navController) }
         composable("details") { DetailsScreen() }
     }
     ```

2. **NavController**  
   Objek yang bertanggung jawab atas perpindahan antar layar.
   - **Fungsi Utama:**
     - Mengatur navigasi antar layar.
     - Menyimpan state backstack layar.
     - Navigasi dengan parameter.
   - **Contoh Kode:**
     ```kotlin
     val navController = rememberNavController()
     Button(onClick = { navController.navigate("details") }) {
         Text("Go to Details")
     }
     ```

3. **Composable**  
   Unit dasar untuk layar. Setiap layar atau komponen didefinisikan sebagai `composable`.
   - **Fungsi Utama:**
     - Mendefinisikan layar berdasarkan rute.
     - Mendukung penerimaan data sebagai parameter.
   - **Contoh Kode:**
     ```kotlin
     @Composable
     fun HomeScreen(navController: NavController) {
         Column {
             Text("Welcome to Home Screen")
             Button(onClick = { navController.navigate("details") }) {
                 Text("Go to Details")
             }
         }
     }
     ```

4. **NavBackStackEntry**  
   Representasi dari layar yang berada dalam backstack navigasi.
   - **Fungsi Utama:**
     - Menyimpan state dan argument layar aktif.
     - Mengakses data navigasi yang diterima.
   - **Contoh Kode:**
     ```kotlin
     composable("details/{id}", arguments = listOf(navArgument("id") { type = NavType.IntType })) { backStackEntry ->
         val id = backStackEntry.arguments?.getInt("id")
         DetailsScreen(id)
     }
     ```

## Jenis Navigasi

### 1. Navigasi Dasar
- Membuat `NavHost` yang mendefinisikan rute.
- **Contoh Kode:**
  ```kotlin
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = "screenA") {
      composable("screenA") { ScreenA(navController) }
      composable("screenB") { ScreenB() }
  }
  ```

### 2. Navigasi dengan Parameter
- Mengirimkan data antar layar dengan mendefinisikan parameter di rute.
- **Contoh Kode:**
  ```kotlin
  composable(
      "screenB/{message}",
      arguments = listOf(navArgument("message") { type = NavType.StringType })
  ) { backStackEntry ->
      val message = backStackEntry.arguments?.getString("message")
      ScreenB(message)
  }
  ```

### 3. Hierarki Navigasi
- **Single Navigation Graph**  
  Cocok untuk aplikasi sederhana, semua rute berada dalam satu `NavHost`.
  - **Contoh Kode:**
    ```kotlin
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { HomeScreen(navController) }
        composable("profile") { ProfileScreen() }
    }
    ```
- **Nested Navigation Graphs**  
  Digunakan untuk aplikasi modular dengan struktur navigasi kompleks.
  - **Contoh Kode:**
    ```kotlin
    NavHost(navController = navController, startDestination = "main") {
        navigation(startDestination = "home", route = "main") {
            composable("home") { HomeScreen(navController) }
            composable("settings") { SettingsScreen() }
        }
    }
    ```
- **Multiple Backstack Navigation**  
  Setiap bagian aplikasi memiliki backstack sendiri, misalnya untuk `BottomNavigation`.
  - **Contoh Kode:**
    ```kotlin
    BottomNavigation {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = "feed") {
            composable("feed") { FeedScreen() }
            composable("messages") { MessagesScreen() }
        }
    }
    ```

## Manajemen State dalam Navigasi
State management memastikan data tetap terjaga meskipun terjadi perubahan layar atau konfigurasi.  

### 1. **SavedStateHandle**  
Menyimpan data di stack navigasi.
- **Contoh Kode:**
  ```kotlin
  val savedStateHandle = navController.previousBackStackEntry?.savedStateHandle
  savedStateHandle?.set("key", "value")
  val value = savedStateHandle?.get<String>("key")
  ```

### 2. **ViewModel**  
Mempertahankan state antar layar yang lebih kompleks.
- **Contoh Kode:**
  ```kotlin
  class MyViewModel : ViewModel() {
      var counter by mutableStateOf(0)
  }
  
  @Composable
  fun CounterScreen(viewModel: MyViewModel) {
      Column {
          Text("Counter: ${viewModel.counter}")
          Button(onClick = { viewModel.counter++ }) {
              Text("Increase")
          }
      }
  }
  ```

### 3. **remember dan rememberSaveable**  
- `remember`: Menyimpan state sementara.
- `rememberSaveable`: Menyimpan state lebih permanen meskipun layar dirotasi.
- **Contoh Kode:**
  ```kotlin
  var count by remember { mutableStateOf(0) }
  var persistentCount by rememberSaveable { mutableStateOf(0) }

  Column {
      Text("Count: $count")
      Button(onClick = { count++ }) {
          Text("Increase Count")
      }
      Text("Persistent Count: $persistentCount")
      Button(onClick = { persistentCount++ }) {
          Text("Increase Persistent Count")
      }
  }
  ```
