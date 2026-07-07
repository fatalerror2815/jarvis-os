package io.jarvisos.app.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SetupScreen(
    onSetupComplete: (String) -> Unit
) {

    var userName by remember {
        mutableStateOf("")
    }

    var error by remember {
        mutableStateOf(false)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),

        contentAlignment = Alignment.Center
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = "WELCOME TO",
                color = Color.Cyan,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "JARVIS",
                color = Color.White,
                fontSize = 42.sp,
                fontWeight = FontWeight.Bold
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Please enter your name",
                color = Color.LightGray,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = userName,
                onValueChange = {

                    userName = it
                    error = false

                },

                singleLine = true,

                label = {
                    Text("Your Name")
                },

                isError = error,

                keyboardOptions = KeyboardOptions(
                    capitalization = KeyboardCapitalization.Words
                ),

                colors = TextFieldDefaults.colors(

                    focusedContainerColor = Color(0xFF1A1A1A),
                    unfocusedContainerColor = Color(0xFF1A1A1A),

                    focusedTextColor = Color.White,
                    unfocusedTextColor = Color.White,

                    focusedLabelColor = Color.Cyan,
                    unfocusedLabelColor = Color.Gray

                )
            )

            Spacer(modifier = Modifier.height(28.dp))

            Button(

                onClick = {

                    if (userName.trim().isEmpty()) {

                        error = true

                    } else {

                        onSetupComplete(userName.trim())

                    }

                },

                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Cyan
                )

            ) {

                Text(
                    text = "Continue",
                    color = Color.Black
                )

            }

        }

    }

}