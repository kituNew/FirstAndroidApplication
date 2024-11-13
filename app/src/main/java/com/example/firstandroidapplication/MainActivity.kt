package com.example.firstandroidapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.firstandroidapplication.ui.theme.FirstAndroidApplicationTheme
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.primarySurface
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import kotlinx.coroutines.selects.select

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FirstAndroidApplicationTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        BottomNavigationBar()
                    }
                    )
                { innerPadding ->

                }
            }
        }
    }
}

@Composable
fun BottomNavigationBar() {
    BottomNavigation(
        backgroundColor = MaterialTheme.colors.primarySurface,
        contentColor = MaterialTheme.colors.onPrimary
    ) {
        BottomNavigationItem(
            icon = { Icon(
                ImageVector.vectorResource(id = R.drawable.ic_mic),
                contentDescription = "Chat")
                   },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(
                ImageVector.vectorResource(id = R.drawable.ic_cam),
                contentDescription = "Chat")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(
                ImageVector.vectorResource(id = R.drawable.ic_translate),
                contentDescription = "Chat")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(
                ImageVector.vectorResource(id = R.drawable.ic_history),
                contentDescription = "Chat")
            },
            selected = false,
            onClick = {}
        )
        BottomNavigationItem(
            icon = { Icon(
                ImageVector.vectorResource(id = R.drawable.ic_star),
                contentDescription = "Chat")
            },
            selected = false,
            onClick = {}
        )
    }
}
