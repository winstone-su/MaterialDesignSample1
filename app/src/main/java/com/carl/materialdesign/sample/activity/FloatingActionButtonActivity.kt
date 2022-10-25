package com.carl.materialdesign.sample.activity

import android.os.Bundle
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.databinding.ActivityFloatingActionButtonBinding
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class FloatingActionButtonActivity : ToolbarActivity<ActivityFloatingActionButtonBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        binding.button.setOnClickListener { _ ->
            binding.floatingButton.run { if (this.isShown) hide() else show() }
            binding.floatingButton.setOnClickListener {
                finish()
            }
        }

        binding.extendedFloatingActionButton.apply {
            setOnClickListener{
                this.text = ""
            }
        }

    }

    override fun setToolBar() {
        mToolbar.title = getString(R.string.floating_action_button)
    }

    override fun getViewBinding(): ActivityFloatingActionButtonBinding = ActivityFloatingActionButtonBinding.inflate(layoutInflater)

}