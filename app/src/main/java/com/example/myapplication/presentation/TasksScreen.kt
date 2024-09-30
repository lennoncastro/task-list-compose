package com.example.myapplication.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.myapplication.MyViewModel
import com.example.myapplication.components.MyAppBar
import com.example.myapplication.components.VerticalList

@Composable
fun TaskScreen(
    myViewModel: MyViewModel
) {
    Scaffold(modifier = Modifier.fillMaxSize(), topBar = {
        MyAppBar()
    }) { innerPadding ->
        val state by myViewModel.state.collectAsState()
        VerticalList(
            tasks = state.tasks,
            onClick = myViewModel::onClick,
            modifier = Modifier.padding(innerPadding),
        )
    }
}