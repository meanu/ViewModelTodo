package com.example.myapplication.view.third

import android.os.Bundle
import android.view.Menu
import androidx.annotation.LayoutRes
import com.example.myapplication.R
import org.koin.androidx.viewmodel.ext.android.getViewModel
import com.example.myapplication.databinding.ThirdLayoutBinding

class ThirdActivity : BindingActivity<ThirdLayoutBinding>() {
    @LayoutRes
    override fun getLayoutResId() = R.layout.third_layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.vm = getViewModel()
        binding.setLifecycleOwner(this)
    }


}