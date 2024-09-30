package com.example.myapplication

import androidx.lifecycle.ViewModel
import com.example.myapplication.data.models.Task
import kotlinx.coroutines.flow.MutableStateFlow


data class State(
    val title: String = "", val tasks: List<Task> = emptyList()
)

typealias GetStringById = (Int) -> String

class MyViewModel(private val getStringById: GetStringById) : ViewModel() {
    private val _state = MutableStateFlow(State())
    val state = _state

    init {
        _state.value = _state.value.copy(tasks = List(10) { Task(it, getStringById(R.string.task_label), false) })
    }

    fun onClick(position: Int) {
        val updateState = _state.value.tasks.toMutableList()
        updateState[position] = updateState[position].copy(isDone = !updateState[position].isDone)
        _state.value = _state.value.copy(tasks = updateState)
    }
}