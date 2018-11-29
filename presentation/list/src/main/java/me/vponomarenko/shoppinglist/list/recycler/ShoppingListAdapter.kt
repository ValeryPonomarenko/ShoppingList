package me.vponomarenko.shoppinglist.list.recycler

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

internal class ShoppingListAdapter : RecyclerView.Adapter<ShoppingItemViewHolder>() {

    private var items = listOf<ShoppingListItem>()

    private var onClickListener: OnItemClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ShoppingItemViewHolder.create(LayoutInflater.from(parent.context), parent, onClickListener)

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ShoppingItemViewHolder, position: Int) {
        items.getOrNull(position)?.let(holder::onBind)
    }

    fun update(items: List<ShoppingListItem>) {
        val diffResult = DiffUtil.calculateDiff(ShoppingListItemDiffUtil(this.items, items))
        diffResult.dispatchUpdatesTo(this)
        this.items = items
    }
}