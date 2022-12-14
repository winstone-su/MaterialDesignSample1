package com.carl.materialdesign.sample.activity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.databinding.ActivityBottomNavigationBinding
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationMenuView
import com.google.android.material.navigation.NavigationBarView

class BottomNavigationActivity : ToolbarActivity<ActivityBottomNavigationBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        initView()
    }

    override fun setToolBar() {
        mToolbar.setTitle(R.string.bottom_navigation)
    }

    override fun getViewBinding(): ActivityBottomNavigationBinding = ActivityBottomNavigationBinding.inflate(layoutInflater)

    private fun initView() {
        binding.run {
            navigation.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
            navigation2.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
            navigation3.setOnItemSelectedListener(mOnNavigationItemSelectedListener)
        }
        setBadge(2, 5)
    }

    private val mOnNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener { item ->
        when(item.itemId) {
            R.id.navigation_home -> {
                binding.message.setText(R.string.title_home)
                return@OnItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                binding.message.setText(R.string.title_dashboard)
                return@OnItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                binding.message.setText(R.string.title_notifications)
                return@OnItemSelectedListener true
            }
            R.id.navigation_test -> {
                binding.message.setText(R.string.title_test)
                return@OnItemSelectedListener true
            }
        }
        false
    }

    /**
     * ???BottomNavigationView ??????Badge ?????????
     *
     * BottomNavigationMenuView???????????????Tab?????????FrameLayout????????????????????????????????????View?????????????????????????????????
     */
    private fun setBadge(index: Int, count: Int) {
        //??????????????????view
        val menuView = binding.navigation3.getChildAt(0) as BottomNavigationMenuView
        //?????????2???itemView
        val itemView = menuView.getChildAt(index) as BottomNavigationItemView
        //??????badgeView
        val badgeView = LayoutInflater.from(this).inflate(R.layout.layout_badge_view, menuView, false)
        //???badgeView?????????itemView???
        itemView.addView(badgeView)
        //?????????view?????????????????????
        val countView = badgeView.findViewById<TextView>(R.id.tv_badge)
        countView.text = count.toString()

        countView.visibility = if (count > 0) View.VISIBLE else View.GONE
    }
}