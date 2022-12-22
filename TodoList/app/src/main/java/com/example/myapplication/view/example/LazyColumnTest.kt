package com.example.myapplication.view.example

import android.util.Log
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.example.myapplication.view.todoList.TodoViewModel

@Composable
fun LazyColumnTest() {
    LazyColumn(modifier = Modifier.fillMaxHeight()) {
        items(10) {
            Item(number = it)
        }
    }
}

@Composable
fun Item(number: Int){
    Card(
        modifier = Modifier
            .padding(12.dp)
            .border(width = 4.dp, color = Color.Black)
            .fillMaxWidth()
            .height(100.dp)
    ){
        Box(contentAlignment = Alignment.Center){
            Text(text = "Hello, World! $number")
        }
    }
}