package com.carl.materialdesign.sample.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.carl.materialdesign.sample.R

/**
 *
 * @ClassName :      MainAdapter
 * @Description :    TODO
 * @Author :         Carl
 * @CreateDate :     2022/10/22 23:14
 * @Version :        1.0
 */
class MainAdapter(private val context: Context, private val data: List<String>) :
    RecyclerView.Adapter<MainAdapter.ViewHolder>(),View.OnClickListener {

    interface OnItemClickListener {
        fun onItemClick(v: View, position: Int)
    }

    var listener: OnItemClickListener? = null
        set(value) {
            field = value
        }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mItemTextView: TextView = itemView.findViewById(R.id.item_textView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_main,parent,false)
        view.setOnClickListener(this)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        // 去掉随机背景色，跟随系统dynamic color
        // holder.mItemTextView.setBackgroundColor(randomColor())
        holder.mItemTextView.text = data[position]
        holder.mItemTextView.tag = position
    }

    override fun getItemCount(): Int = data.size

    override fun onClick(v: View) {
        listener?.run { this.onItemClick(v, v.tag as Int) }
    }
}