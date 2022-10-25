package com.carl.materialdesign.sample.activity

import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.view.Menu
import android.view.View
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.adapter.MainAdapter
import com.carl.materialdesign.sample.databinding.ActivityMainBinding

class MainActivity : ToolbarActivity<ActivityMainBinding>() {

    private lateinit var dataList: MutableList<String>
    private lateinit var mAdapter: MainAdapter

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)


    override fun initView(savedInstanceState: Bundle?) {
        mToolbar.navigationIcon = null

        //回调刷新toolbar的menu，页面初始化或者在需要的时候调用
        invalidateOptionsMenu()

        dataList = mutableListOf(
            getString(R.string.swipe_refresh_layout),
            getString(R.string.floating_action_button),
            getString(R.string.snack_bar),
            getString(R.string.tab_layout),
            getString(R.string.card_view),
            getString(R.string.bottom_navigation),
            getString(R.string.collapsing_toolbar),
            getString(R.string.text_input_layout),
            getString(R.string.search_view),
            getString(R.string.tab_layout_custom_view),
            getString(R.string.drawer_layout),
            getString(R.string.bottom_sheet),
            getString(R.string.material_button),
            getString(R.string.shapeable_image_view),
            getString(R.string.badge_drawable),
            getString(R.string.drag_recyclerview),
            getString(R.string.notification),
            getString(R.string.float_view),
            getString(R.string.guide_line),
            getString(R.string.divider)
        )

        mAdapter = MainAdapter(this,dataList)
        binding.recycleView.run {
            adapter = mAdapter
        }

        setListener()

        initFloatingButtonImage()
    }

    override fun setToolBar(){}

    private fun setListener() {
        mAdapter.listener = object : MainAdapter.OnItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                when(position) {
                    1 -> openActivity(FloatingActionButtonActivity::class.java)
                    2 -> openActivity(SnackbarActivity::class.java)
                }
            }

        }
    }

    override fun onPrepareOptionsMenu(menu: Menu?): Boolean {
        return super.onPrepareOptionsMenu(menu)
    }

    /**
     * 修改主题后会重建，初始化显示icon
     */
    private fun initFloatingButtonImage() {
        if (isDarkTheme()) {
            binding.floatingButton.setImageResource(R.mipmap.ic_day)
        } else {
            binding.floatingButton.setImageResource(R.mipmap.ic_night)
        }
    }

    /**
    * 是否深色主题
    */
    private fun isDarkTheme(): Boolean {
        val flag = resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK
        return flag == Configuration.UI_MODE_NIGHT_YES
    }

    private fun openActivity(targetActivityClass: Class<*>) {
        startActivity(Intent(this@MainActivity, targetActivityClass))
    }

}