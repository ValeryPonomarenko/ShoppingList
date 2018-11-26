package me.vponomarenko.shoppinglist.list.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import me.vponomarenko.shoppinglist.domain.entity.ListItem

internal class ShoppingListAdapter : RecyclerView.Adapter<ShoppingItemViewHolder>() {

    var items: List<ListItem>? = null

    private var onClickListener: OnItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShoppingItemViewHolder.create(LayoutInflater.from(parent.context), parent, onClickListener)

    override fun getItemCount() = items?.size ?: 0

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        items?.get(position)?.let(holder::onBind)
    }
}