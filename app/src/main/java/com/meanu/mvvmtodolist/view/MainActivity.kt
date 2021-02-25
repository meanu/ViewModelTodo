package com.meanu.mvvmtodolist.view

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import com.meanu.mvvmtodolist.R
import com.meanu.mvvmtodolist.view.ui.TodoActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val ab: ActionBar? = supportActionBar
        ab?.setTitle("Stelli")

        button2.setOnClickListener {
            startActivity(Intent(this, TodoActivity::class.java))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_search, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            R.id.bookmark ->
                Toast.makeText(this, "Test", Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}