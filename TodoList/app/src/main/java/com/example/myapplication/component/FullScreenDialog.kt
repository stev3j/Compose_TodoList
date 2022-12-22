package com.example.myapplication.component

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.DialogProperties
import com.example.myapplication.model.TodoList
import com.example.myapplication.view.todoList.TodoViewModel
import java.util.*

@Composable
fun FullScreenDialog(
    openDialog: MutableState<Boolean>, todoViewModel: TodoViewModel
) {
    var name by remember { mutableStateOf(TextFieldValue("")) }

    AlertDialog(properties = DialogProperties(
        dismissOnBackPress = true,
        dismissOnClickOutside = false
    ),
        shape = RoundedCornerShape(16.dp), onDismissRequest = {
            // Dismiss the dialog when the user clicks outside the dialog or on the back
            openDialog.value = false
        }, title = {
            Text(
                text = "Add Task",
                modifier = Modifier.padding(20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp
            )
        },
        text = {
            Column(
                modifier = Modifier.padding(10.dp),
            ) {
                TextField(
                    value = name,
                    onValueChange = { newText ->
                        name = newText
                    },
                    modifier = Modifier.fillMaxWidth().padding(top = 20.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = TextFieldDefaults.textFieldColors(
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent
                    )
                )
            }
        }, confirmButton = {
            Button(
                onClick = {
                    if (name.text.isNotEmpty()) { // name 칸이 비지 않았다면,
                        todoViewModel.addTodoList(
                            TodoList(
                                id = UUID.randomUUID().toString(),
                                name = name.text,
                                isComplete = false
                            )
                        )
                        openDialog.value = false // 창 닫기
                    }
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Green),
            ) {
                Text(
                    "Add", color = Color.White,
                )
            }
        }, dismissButton = {
            Button(
                onClick = {
                    openDialog.value = false
                },
                colors = ButtonDefaults.buttonColors(backgroundColor = Color.Red),
            ) {
                Text(
                    "Cancel", color = Color.White,
                )
            }
        }
    )
}