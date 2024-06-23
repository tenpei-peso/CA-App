package com.example.unsplashapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.unsplashapp.presentation.root.ScreenRoot
import com.example.unsplashapp.presentation.search_photos.SearchPhotosScreen
import com.example.unsplashapp.presentation.theme.UnsplashAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UnsplashAppTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = ScreenRoot.SearchPhotosScreen.route
                    ) {
                        //画像検索画面
                        composable(route = ScreenRoot.SearchPhotosScreen.route) {
                            SearchPhotosScreen()
                        }
                        //画像詳細画面
                        composable(route = ScreenRoot.PhotoDetailScreen.route) {
                            Text(text = "PhotoDetailScreen")
                        }
                    }
                }
            }
        }
    }
}

