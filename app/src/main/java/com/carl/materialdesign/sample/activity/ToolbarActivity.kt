package com.carl.materialdesign.sample.activity

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.carl.materialdesign.sample.R
import com.carl.materialdesign.sample.util.inflateBindingWithGeneric
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar

/**
 *
 * @ClassName :      ToolBarActivity
 * @Description :    TODO
 * @Author :         Carl
 * @CreateDate :     2022/10/21 23:35
 * @Version :        1.0
 */
abstract class ToolbarActivity<VB: ViewBinding>: AppCompatActivity(){
    protected lateinit var binding: VB
    protected open lateinit var mToolbar: MaterialToolbar

    abstract fun initView(savedInstanceState: Bundle?)

    abstract fun setToolBar()

    abstract fun getViewBinding(): VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
        mToolbar = findViewById(R.id.toolbar)
        setToolBar()
        setListener()
        initView(savedInstanceState)
    }

    private fun setListener() {

        /**
         * toolbar上back的事件处理
         */
        mToolbar.setNavigationOnClickListener {
            finish()
        }

        /**
         * toolbar上menu的事件处理
         */
        mToolbar.setOnMenuItemClickListener {
            when (it.itemId) {
                R.id.menu_author -> {
                    Snackbar
                        .make(binding.root, "作者：winstone", Snackbar.LENGTH_LONG)
                        .setAction("记住了") {
                            Toast.makeText(this, "Happier", Toast.LENGTH_LONG).show()
                        }
                        .show()
                }
                R.id.menu_share -> {
                    Toast.makeText(this, "分享", Toast.LENGTH_SHORT).show()
                }
                R.id.menu_settings -> {
                    Toast.makeText(this, "设置", Toast.LENGTH_SHORT).show()
                }
            }
            return@setOnMenuItemClickListener true
        }
    }




}