package com.carl.materialdesign.sample.activity

import android.os.Bundle
import android.widget.Toast
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.databinding.ActivityCardViewBinding

class CardViewActivity : ToolbarActivity<ActivityCardViewBinding>() {
    override fun initView(savedInstanceState: Bundle?) {
        binding.cardViewElevated.setOnClickListener {
            Toast.makeText(this@CardViewActivity, "CardView", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setToolBar() {
        mToolbar.setTitle(R.string.card_view)
    }

    override fun getViewBinding(): ActivityCardViewBinding = ActivityCardViewBinding.inflate(layoutInflater)

}