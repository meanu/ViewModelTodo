package com.example.myapplication.model

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

data class MainData( // Use the Room to make this page.
    val id:String, // 여기서 ? 는 null값이 올 수 있다는것.
    val title: String,
    val description: String,
    val createdDate: String
)