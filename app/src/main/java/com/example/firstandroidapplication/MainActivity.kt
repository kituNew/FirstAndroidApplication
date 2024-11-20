package com.example.firstandroidapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstandroidapplication.ui.theme.FirstAndroidApplicationTheme
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstandroidapplication.screen.TranslationScreen
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.selects.select

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAndroidApplicationTheme {
                MainScreen()
            }
        }
    }

    @Composable
    fun MainScreen() {
        val navController = rememberNavController()
        Scaffold(
            bottomBar = {
                BottomNavigationBar(navController)
            }
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "translate"
            ) {
                composable("mic") {}
                composable("cam") {}
                composable("translate") { TranslationScreen() }
                composable("history") {}
                composable("star") {}
            }
        }
    }

    private val Destinations = listOf("mic", "cam", "translate", "history", "star")

    @Composable
    fun BottomNavigationBar(navController: NavController) {
        var selectedItem by rememberSaveable { mutableIntStateOf(2) }
        val icons = listOf(
            ImageVector.vectorResource(R.drawable.ic_mic),
            ImageVector.vectorResource(R.drawable.ic_cam),
            ImageVector.vectorResource(R.drawable.ic_translate),
            ImageVector.vectorResource(R.drawable.ic_history),
            ImageVector.vectorResource(R.drawable.ic_star)
        )

        NavigationBar (
            content = {
                Destinations.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                imageVector = icons[index],
                                contentDescription = item
                            )
                        },
                        label = { Text(item) },
                        selected = selectedItem == index,
                        onClick = {
                            selectedItem = index
                            navController.navigate(item)
                        }
                    )
                }
            }
        )
    }

    @Composable
    fun RowScope.BottomNavigationItem(
        selected: Boolean,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        alwaysShowLabel: Boolean = true,
        icon: @Composable () -> Unit,
        selectedIcon: @Composable () -> Unit = icon,
        label: @Composable (() -> Unit)? = null
    ) {
        NavigationBarItem (
            selected = selected,
            onClick = onClick,
            modifier = modifier,
            enabled = enabled,
            alwaysShowLabel = alwaysShowLabel,
            icon = if (selected) selectedIcon else icon,
            label = label,
            colors = NavigationBarItemDefaults.colors(
                selectedIconColor = NavigationDefaults.navigationSelectedItemColor(),
                unselectedIconColor = NavigationDefaults.navigationContentColor(),
                selectedTextColor = NavigationDefaults.navigationSelectedItemColor(),
                unselectedTextColor = NavigationDefaults.navigationContentColor(),
                indicatorColor = NavigationDefaults.navigationIndicatorColor(),
            )
        )
    }

    object NavigationDefaults {
        @Composable
        fun navigationContentColor() = MaterialTheme.colorScheme.onSurfaceVariant

        @Composable
        fun navigationSelectedItemColor() = MaterialTheme.colorScheme.onPrimaryContainer

        @Composable
        fun navigationIndicatorColor() = MaterialTheme.colorScheme.primaryContainer
    }

}