package com.carl.materialdesign.sample.activity

import android.os.Bundle
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.databinding.ActivitySwipeRefreshLayoutBinding

class SwipeRefreshLayoutActivity : ToolbarActivity<ActivitySwipeRefreshLayoutBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        binding.swipeRefreshLayout.run {
            setColorSchemeResources(
                android.R.color.holo_blue_bright,
                android.R.color.holo_green_light,
                android.R.color.holo_orange_light
            )
            setOnRefreshListener {
                this.postDelayed({
                                 this.isRefreshing = false
                    binding.tvRefresh.text = "刷新已完成"
                },2000L)
            }
            
        }

    }

    override fun setToolBar() {
        mToolbar.setTitle(R.string.swipe_refresh_layout)
    }

    override fun getViewBinding(): ActivitySwipeRefreshLayoutBinding = ActivitySwipeRefreshLayoutBinding.inflate(layoutInflater)

}