package com.example.myapplication.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class ListAdapter(val data: List<TaskItemVo>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class ParentHolder(view: View) : RecyclerView.ViewHolder(view)

    class ItemHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun getItemViewType(position: Int): Int {
        val itemData = data[position]
        return if (itemData.childItemList.isNullOrEmpty()) {
            1//Item类型
        } else {
            0//Parent类型
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if (viewType == 1) {
            ItemHolder(layoutInflater.inflate(R.layout.item_node, parent, false))
        } else {
            ParentHolder(layoutInflater.inflate(R.layout.item_parent_node, parent, false))
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemData = data[position]
        if (itemData.childItemList.isNullOrEmpty()) {//正常类型
            val itemHolder = holder as ItemHolder
            val itemName = itemHolder.itemView.findViewById<TextView>(R.id.item_name)
            itemName.text = itemData.contentName
        } else {//父节点类型
            val parentHolder = holder as ParentHolder
            val itemParentName = parentHolder.itemView.findViewById<TextView>(R.id.item_parent_name)
            val itemParentExpend =
                parentHolder.itemView.findViewById<ImageView>(R.id.item_parent_expend)
            val itemParentList =
                parentHolder.itemView.findViewById<RecyclerView>(R.id.item_parent_list)

            itemParentName.text = itemData.contentName
            setParentExpend(itemData.isExpend, itemParentExpend, itemParentList)

            itemParentExpend.setOnClickListener {
                itemData.isExpend = !itemData.isExpend
                setParentExpend(itemData.isExpend, itemParentExpend, itemParentList)
            }
            itemParentList.addItemDecoration(VDividerItemDecoration(parentHolder.itemView.context))
            itemParentList.adapter = ListAdapter(itemData.childItemList)
        }
    }

    private fun setParentExpend(
        isExpend: Boolean,
        itemParentExpend: ImageView,
        itemParentList: RecyclerView
    ) {
        if (isExpend) {
            itemParentExpend.setImageResource(R.drawable.ic_up)
            itemParentList.visibility = View.VISIBLE
        } else {
            itemParentExpend.setImageResource(R.drawable.ic_down)
            itemParentList.visibility = View.GONE
        }
    }
}