package com.example.myapplication.data.models


data class Task(val id: Int, val prefix: String, val isDone: Boolean) {
    val title = "$prefix $id"
}