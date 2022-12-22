package com.example.myapplication.view

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.myapplication.TodoListScreen
import com.example.myapplication.component.FullScreenDialog
import com.example.myapplication.view.todoList.TodoViewModel

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun HomeScreens() {
    val openDialog = remember { mutableStateOf(false) } // Alert Dialog 가 띄워져 있는지 확인
    val todoViewModel by remember { mutableStateOf(TodoViewModel()) } // 왜 굳이 이렇게 만듦?

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    openDialog.value = true; // fab을 눌렀을 때 openDialog 를 true 로 설정
                }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = "TODO item Add"
                )
                if (openDialog.value) { // openDialog 가 true 라면 Alert Dialog 창을 띄움 -> 눌렀을 때 그냥 아래를 실행 시키면 안되나?
                    FullScreenDialog(
                        openDialog = openDialog,
                        todoViewModel = todoViewModel
                    )
                }
            }
        },
//        topBar = {
//            TopAppBar() {
//                Text("To do App")
//            }
//        }
    ) { //body
        Column(
            modifier = Modifier.padding(20.dp).fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TodoListScreen(todoViewModel)
        }
    }
}