package com.carl.materialdesign.sample.activity

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.databinding.ActivitySnackbarBinding
import com.google.android.material.snackbar.Snackbar

/**
 * see more:
 * https://github.com/material-components/material-components-android/blob/master/docs/components/Snackbar.md
 */
class SnackbarActivity : ToolbarActivity<ActivitySnackbarBinding>() {
    companion object {
        private const val TAG = "SnackbarActivity"
    }
    override fun initView(savedInstanceState: Bundle?) {
        binding.button.setOnClickListener {
            Snackbar.make(binding.constraintLayout,"普通的Snackbar",Snackbar.LENGTH_SHORT).show()
        }
        binding.button2.setOnClickListener {
            //LENGTH_INDEFINITE 无期限显示,点击了Action后消失
            val mSnackbar = Snackbar.make(binding.constraintLayout, "带Action的Snackbar", Snackbar.LENGTH_INDEFINITE)
            mSnackbar.setAction("I Know") {
                Toast.makeText(this,"Normal Toast",Toast.LENGTH_SHORT).show()
            }
            //设置Action的颜色
            mSnackbar.setActionTextColor(Color.YELLOW)
            mSnackbar.show()
        }

        binding.button3.setOnClickListener {
            val mSnackbar = Snackbar.make(binding.constraintLayout, "已加入行程", Snackbar.LENGTH_INDEFINITE)
            //设置Snackbar的背景颜色
            mSnackbar.setBackgroundTint(ContextCompat.getColor(this@SnackbarActivity,R.color.colorPrimary))
            //设置Action文字的背景颜色
            mSnackbar.setTextColor(Color.WHITE)
            mSnackbar.setAction("I Know") {
                Toast.makeText(this,"Long Toast",Toast.LENGTH_LONG).show()
            }.show()
            //监听Snackbar显示和隐藏的回调
            mSnackbar.addCallback(object : Snackbar.Callback() {
                override fun onDismissed(transientBottomBar: Snackbar?, event: Int) {
                    super.onDismissed(transientBottomBar, event)
                    Log.e(TAG, "onDismissed: --> " )
                }

                override fun onShown(sb: Snackbar?) {
                    super.onShown(sb)
                    Log.e(TAG, "onShown: -->" )
                }
            })
        }

        binding.button4.setOnClickListener {
            Snackbar.make(binding.constraintLayout,"AnchorView",Snackbar.LENGTH_SHORT)
                .setAnchorView(binding.floatingActionButton)
                .show()
        }
    }

    override fun setToolBar() {
        mToolbar.title = "SnackBar"
    }

    override fun getViewBinding(): ActivitySnackbarBinding  =  ActivitySnackbarBinding.inflate(layoutInflater)

}