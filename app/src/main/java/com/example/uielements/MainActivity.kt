package com.example.uielements

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                UiElementsScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UiElementsScreen() {
    val tabTitles = listOf("Home", "Profile", "Settings")
    var selectedTab by remember { mutableIntStateOf(0) }
    var inputText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            // ---------------------------------------------
            // Toolbar
            // ---------------------------------------------
            TopAppBar(
                title = { Text(text = "UI Elements Demo") }
            )
        },
        bottomBar = {
            // ---------------------------------------------
            // Status Bar
            // ---------------------------------------------
            BottomAppBar {
                Text(
                    text = "Tab: ${tabTitles[selectedTab]} | Characters typed: ${inputText.length}",
                    modifier = Modifier.padding(start = 16.dp),
                    fontSize = 14.sp
                )
            }
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            // ---------------------------------------------
            // Tab Bar
            // ---------------------------------------------
            TabRow(selectedTabIndex = selectedTab) {
                tabTitles.forEachIndexed { index, title ->
                    Tab(
                        selected = selectedTab == index,
                        onClick = { selectedTab = index },
                        text = { Text(text = title) }
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(24.dp)
            ) {
                // ---------------------------------------------
                // Label
                // ---------------------------------------------
                Text(
                    text = when (tabTitles[selectedTab]) {
                        "Home" -> "Enter your favourite hobby:"
                        "Profile" -> "Enter your full name:"
                        else -> "Enter a settings note:"
                    },
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                // ---------------------------------------------
                // TextField
                // ---------------------------------------------
                OutlinedTextField(
                    value = inputText,
                    onValueChange = { inputText = it },
                    label = { Text("Type here") },
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(20.dp))

                Text(
                    text = if (inputText.isBlank())
                        "Nothing entered yet."
                    else
                        "You typed: $inputText",
                    fontSize = 16.sp
                )
            }
        }
    }
}
