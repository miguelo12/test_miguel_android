package com.example.test_miguel

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.rememberNavController
import com.example.test_miguel.presentation.components.navigation.AppNavigationBar
import com.example.test_miguel.presentation.components.navigation.AppNavigationHost
import com.example.test_miguel.presentation.screen.product.ProductsScreen
import com.example.test_miguel.ui.theme.Test_miguelTheme
import com.example.test_miguel.util.Event
import com.example.test_miguel.util.EventBus
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val lifecycle = LocalLifecycleOwner.current.lifecycle
            LaunchedEffect(key1 = lifecycle) {
                lifecycle.repeatOnLifecycle(state = Lifecycle.State.STARTED) {
                    EventBus.events.collect { events ->
                        when (events) {
                            is Event.Toast -> {
                                Toast.makeText(
                                    this@MainActivity,
                                    events.message,
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }
                }
            }
            Test_miguelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainCompose()
                }
            }
        }
    }
}

@Composable
fun MainCompose() {
    val navController = rememberNavController()
    AppNavigationHost(navController = navController, modifier = Modifier)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Test_miguelTheme {
        MainCompose()
    }
}