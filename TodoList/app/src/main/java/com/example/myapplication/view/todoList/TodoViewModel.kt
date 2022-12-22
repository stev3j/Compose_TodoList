package com.example.myapplication.view.todoList

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.myapplication.model.TodoList

class TodoViewModel : ViewModel() {
    private var _todoList = mutableStateListOf<TodoList>()

    fun getAllToDoList(): List<TodoList> {
        return _todoList;
    }

    fun addTodoList(todoItem: TodoList) {
        _todoList.add(todoItem)
    }

    fun removeTodoItem(todoItem: TodoList) {

        _todoList.remove(todoItem)
    }

    fun markAsComplete(todoItem: TodoList, value: Boolean) {
        val index = _todoList.indexOf(todoItem);

        _todoList[index] = _todoList[index].let {
            it.copy(
                id = it.id,
                name = it.name,
                isComplete = value
            )
        }
    }
}