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
        private const val ALPHA_IF_CHECKED = 0.5f
        private const val ALPHA_IF_NOT_CHECKED = 1f

        fun create(inflater: LayoutInflater, container: ViewGroup, clickListener: OnItemClick?) =
            ShoppingItemViewHolder(inflater.inflate(R.layout.item_list, container, false), clickListener)
    }

    var isChecked = false

    fun onBind(item: ShoppingListItem) {
        text_title.text = item.title
        isChecked = item.isChecked
        itemView.setOnClickListener {
            onClickListener?.invoke(item)
        }
        lottie_animation.progress = if (item.isChecked) 1f else 0f
        containerView.alpha = if (item.isChecked) ALPHA_IF_CHECKED else ALPHA_IF_NOT_CHECKED
    }
}