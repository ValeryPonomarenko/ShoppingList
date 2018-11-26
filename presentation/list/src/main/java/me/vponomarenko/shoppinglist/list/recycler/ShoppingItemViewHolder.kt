package me.vponomarenko.shoppinglist.list.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*
import me.vponomarenko.shoppinglist.domain.entity.ListItem
import me.vponomarenko.shoppinglist.list.R

internal class ShoppingItemViewHolder(
    override val containerView: View,
    private val onClickListener: OnItemClick?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    companion object {
        fun create(inflater: LayoutInflater, container: ViewGroup, clickListener: OnItemClick?) =
            ShoppingItemViewHolder(inflater.inflate(R.layout.item_list, container, false), clickListener)
    }

    fun onBind(item: ListItem) {
        cb_item_name.text = item.title
        cb_item_name.isChecked = item.isChecked
        cb_item_name.setOnClickListener { onClickListener?.invoke(item) }
    }
}