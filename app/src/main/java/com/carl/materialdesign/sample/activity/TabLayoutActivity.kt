package com.carl.materialdesign.sample.activity

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.databinding.ActivityTabLayoutBinding
import com.carl.materialdesign.sample.fragment.Fragment1
import com.carl.materialdesign.sample.fragment.Fragment2
import com.carl.materialdesign.sample.fragment.Fragment3
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import java.lang.IllegalArgumentException

class TabLayoutActivity : ToolbarActivity<ActivityTabLayoutBinding>() {
    private var defaultIndex = 0
    companion object {
        private val tabTitles = arrayOf("Android", "Kotlin", "Flutter")
        private val companyMap = mapOf("苹果" to 2, "亚马逊" to 0, "谷歌" to 8, "微软" to 0, "阿里巴巴" to 0, "腾讯" to 0, "脸书" to 0, "三星" to 0, "思科" to 2)
    }

    override fun initView(savedInstanceState: Bundle?) {
        initViewPager2()

        //基础样式
        initTabLayout1()
        initTabLayout2()
        initTabLayout3()
        initTabLayout4()
        initTabLayout5()
        initTabLayout6()
    }

    private fun initTabLayout1() {
        //tabLayout关联viewpager2
        TabLayoutMediator(
            binding.tabLayout1, binding.viewPager2
        ) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        //设置默认选中
        binding.tabLayout1.getTabAt(defaultIndex)?.select()
    }

    /**
     * 添加icon & 去掉indicator
     */
    private fun initTabLayout2() {
        TabLayoutMediator(binding.tabLayout2,binding.viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        for (index in 0..binding.tabLayout2.tabCount) {
            binding.tabLayout2.getTabAt(index)?.setIcon(R.mipmap.launch)
        }
    }

    /**
     * style 字体大小、加粗 & 顶部indicator
     */
    private fun initTabLayout3() {
        TabLayoutMediator(binding.tabLayout3,binding.viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
    }

    /**
     * 下划线样式 & tab分割线
     */
    private fun initTabLayout4() {
        TabLayoutMediator(binding.tabLayout4,binding.viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        //设置分隔线
        for (index in 0.. binding.tabLayout4.tabCount) {
            val linearLayout = binding.tabLayout4.getChildAt(index) as? LinearLayout
            linearLayout?.let {
                it.showDividers = LinearLayout.SHOW_DIVIDER_END
                it.dividerDrawable = ContextCompat.getDrawable(this@TabLayoutActivity,R.drawable.shape_tab_divider)
                it.dividerPadding = 30
            }
        }
    }

    /**
     * Badge 数字 & 红点
     */
    private fun initTabLayout5() {
        TabLayoutMediator(binding.tabLayout5,binding.viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()
        //数字
        binding.tabLayout5.getTabAt(defaultIndex)?.let { tab ->
            tab.orCreateBadge.apply {
                backgroundColor = Color.RED
                maxCharacterCount = 3
                number = 999
                badgeTextColor = Color.WHITE
            }
        }
        //红点
        binding.tabLayout5.getTabAt(1)?.let { tab  ->
            tab.orCreateBadge.apply {
                backgroundColor = ContextCompat.getColor(this@TabLayoutActivity,R.color.orange)
            }
        }
    }

    /**
     * TabLayout样式 & 选中字体加粗
     */
    private fun initTabLayout6(){
        TabLayoutMediator(binding.tabLayout6,binding.viewPager2) { tab, position ->
            tab.text = tabTitles[position]
        }.attach()

        binding.tabLayout6.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener{
            override fun onTabSelected(tab: TabLayout.Tab?) {
                switchTextStyle(tab)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                switchTextStyle(tab)
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
            }

        })
    }

    /**
     * 隐藏tab count红点提示function & tab宽度
     */
    private fun initTabLayout7() {

    }

    private fun switchTextStyle(tab: TabLayout.Tab?) {
        tab?.let {
            val textView = it.view.getChildAt(1) as TextView
            textView.typeface = Typeface.defaultFromStyle(if (it.isSelected) Typeface.BOLD else Typeface.NORMAL)
        }
    }



    override fun setToolBar() {
        mToolbar.setTitle(R.string.tab_layout)
    }

    override fun getViewBinding(): ActivityTabLayoutBinding =
        ActivityTabLayoutBinding.inflate(layoutInflater)

    /**
     * init viewpager2
     */
    private fun initViewPager2() {
        binding.viewPager2.run {
            adapter = SimpleFragmentPagerAdapter(this@TabLayoutActivity)
            registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
                override fun onPageScrollStateChanged(state: Int) {
                    super.onPageScrollStateChanged(state)

                }

                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {
                    super.onPageScrolled(position, positionOffset, positionOffsetPixels)
                }

                override fun onPageSelected(position: Int) {
                    super.onPageSelected(position)
                }
            })
        }
    }


    private inner class SimpleFragmentPagerAdapter constructor(fm: FragmentActivity) :
        FragmentStateAdapter(fm) {
        private val fragment = arrayOf(Fragment1(), Fragment2(), Fragment3())
        override fun getItemCount(): Int = fragment.size

        override fun createFragment(position: Int): Fragment {
            return when (position) {
                0 -> Fragment1()
                1 -> Fragment2()
                2 -> Fragment3()
                else -> throw IllegalArgumentException("数组异常")
            }
        }

    }

}