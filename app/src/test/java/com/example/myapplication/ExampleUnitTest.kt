package com.example.myapplication

import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun bubblesort() {
        val array: ArrayList<Int> = arrayListOf(3,4,2,1,5)
        for (i in 0 until array.count()-1) {
            for (j in 2 until 0){
                println("asdf")
//                if(array[j] < array[j-1]){
//                    array[j-1] = array[j].also { array[j] = array[j-1] }
//                }
            }
            if(array[i] > array[i+1]){
                array[i] = array[i+1].also { array[i+1] = array[i] } //swap
                }

        }
        println(array)
//        val myComponent: MyComponent = DaggerMyComponent.create()
//        println("result = " + myComponent.getString())
    }
}