package com.example.example

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Second(name: String,age:Int,navigationToFirst:()->Unit){
    Column(Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center)
    {
        Text("Second screen")
        Spacer(modifier = Modifier.height(16.dp))

        Log.d("SecondScreen", "Received age: $age")

        Text("Welcome $name")
        Text("Welcome $age")
        Button(onClick = { navigationToFirst() }) {
            Text("For First screen")
        }
    }
}
@Preview(showBackground = true)
@Composable
fun Showingg(){
    Second("abc",3,{})

}