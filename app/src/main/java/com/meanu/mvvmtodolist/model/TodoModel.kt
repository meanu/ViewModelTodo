package com.meanu.mvvmtodolist.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ToDo")
data class TodoModel( // Use the Room to make this page.
        @PrimaryKey(autoGenerate = true)
        var id: Long?, // 여기서 ? 는 null값이 올 수 있다는것.
        @ColumnInfo(name = "title")
        var title: String?,
        @ColumnInfo(name = "description")
        var description: String,
        @ColumnInfo(name = "createdDate")
        var createdDate: String
){
constructor(): this(null,"","","")
}