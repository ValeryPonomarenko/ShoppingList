package me.vponomarenko.shoppinglist.list.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_list.*
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem
import me.vponomarenko.shoppinglist.list.R

internal class ShoppingItemViewHolder(
    override val containerView: View,
    private val onClickListener: OnItemClick?
) : RecyclerView.ViewHolder(containerView), LayoutContainer {
    companion object {
        fun create(inflater: LayoutInflater, container: ViewGroup, clickListener: OnItemClick?) =
            ShoppingItemViewHolder(inflater.inflate(R.layout.item_list, container, false), clickListener)
    }

    fun onBind(item: ShoppingListItem) {
        text_title.text = item.title
        itemView.setOnClickListener { onClickListener?.invoke(item) }
        if (item.isChecked) {
            lottie_animation.playAnimation()
        } else {
            lottie_animation.progress = 0f
        }
    }
}