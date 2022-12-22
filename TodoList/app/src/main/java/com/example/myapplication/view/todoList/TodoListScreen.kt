package com.example.myapplication

import android.util.Log
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
fun TodoListScreen(todoViewModel: TodoViewModel) {
    if (todoViewModel.getAllToDoList().isEmpty())// to_do list 에 아무것도 담기지 않았을 때
        Box(
            modifier = Modifier.fillMaxSize(), // 이걸 해주지 않으면 text를 감싼 상태 밖에 안됨
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Nothing Here "
            )
        }
    else {
        LazyColumn(modifier = Modifier.fillMaxHeight()) {
            items(todoViewModel.getAllToDoList()) { // getAllToDoList를 했을 때 출력되는 길이만큼 아래가 반복된다.
                Log.e("_todoList", "" + it.isComplete)
                Card(
                    backgroundColor = Color.Gray,
                    shape = RoundedCornerShape(20.dp),
                    elevation = 1.dp,
                    modifier = Modifier.padding(5.dp)
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp),
                    ) {
                        Text(
                            it.name,
                            textDecoration =
                            if (it.isComplete) {   // check if to_do item is complete then task will be show as line through
                                TextDecoration.LineThrough
                            } else {
                                TextDecoration.None //other wise none
                            }
                        )
                        Spacer(modifier = Modifier.fillMaxSize(0.7f))
                        Checkbox(
                            checked = it.isComplete, //value of the checkbox return from to_do list
                            onCheckedChange = { value ->
                                todoViewModel.markAsComplete(
                                    todoItem = it,
                                    value = !value, // reverse the value because if to_do is complete then false (incomplete) else true (complete).
                                )
                            },
                        )
                        Spacer(modifier = Modifier.width(10.dp))
                        Icon(

                            imageVector = Icons.Filled.Delete, contentDescription = "Delete",

                            modifier = Modifier.clickable {
                                todoViewModel.removeTodoItem(it) // remove the todo item from list
                            },
                            tint = Color.Red
                        )
                    }
                }
            }
        }
    }
}