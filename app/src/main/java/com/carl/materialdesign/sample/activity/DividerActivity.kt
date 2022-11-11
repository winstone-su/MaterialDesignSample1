package com.carl.materialdesign.sample.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.databinding.ActivityDividerBinding

class DividerActivity : ToolbarActivity<ActivityDividerBinding>() {
    private var isShow = true

    override fun initView(savedInstanceState: Bundle?) {
// for android:animateLayoutChanges="true"
        binding.run {
            btnVisible.setOnClickListener {
                tvAbout.visibility = if (isShow) View.GONE else View.VISIBLE
                isShow = !isShow
            }

        }
    }

    override fun setToolBar() {
        mToolbar.setTitle(R.string.divider)
    }

    override fun getViewBinding(): ActivityDividerBinding = ActivityDividerBinding.inflate(layoutInflater)

}