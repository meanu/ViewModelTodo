package com.meanu.mvvmtodolist.TodoDAO

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.meanu.mvvmtodolist.model.TodoModel

@Dao
interface TodoDAO {

    @Query("SELECT * from Todo ORDER BY createdDate ASC")
    fun getTodoList(): LiveData<List<TodoModel>>

    @Insert
    fun insertTodo(todoModel: TodoModel)

    @Query("DELETE FROM ToDo WHERE title= :string")
     fun deleteUser(string: String)

    @Query("SELECT * from Todo ORDER BY createdDate ASC")
    fun findAll(): androidx.paging.DataSource.Factory<Int, TodoModel>
}
//이곳에서 LIVEDATA 라는것이 사용 되었다.
//Livedata는 액티비티의 생명주기를 인식하고 활동
// 또한 제네릭 클래스이며,
//중요한 점은 액티비티의 생명주기를 인식하며 데이터의 변화를 observe 할 수 있다는 것.
