package com.example.example

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FirstScreen(navigationToSecond:(String,Int)->Unit){
    val name = remember  { mutableStateOf("") }
    val age = remember { mutableStateOf("")}
    Column(
        modifier = Modifier
            .fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("First screen")
        OutlinedTextField(
            value=name.value,
            onValueChange = {name.value=it}
        )
        OutlinedTextField(
            value = age.value,
            onValueChange = {
                // Only allow numeric input for age
                if (it.all { char -> char.isDigit() }) {
                    age.value = it
                }
            },
            label = { Text("Enter age") }
        )
        Button(
            onClick = {
                // Debug: Print the current age value
                Log.d("FirstScreen", "Age before conversion: ${age.value}")

                // Convert age input to integer, default to 0 if invalid
                val validAge = age.value.toIntOrNull() ?: 0

                // Debug: Print the valid age
                Log.d("FirstScreen", "Valid age after conversion: $validAge")

                navigationToSecond(name.value, validAge)
            }
        ) {
            Text("Second screen")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Showing(){
    //FirstScreen({})
}