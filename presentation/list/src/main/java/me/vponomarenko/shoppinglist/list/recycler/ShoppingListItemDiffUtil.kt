package me.vponomarenko.shoppinglist.list.recycler

import androidx.recyclerview.widget.DiffUtil
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

class ShoppingListItemDiffUtil(
    private val old: List<ShoppingListItem>,
    private val new: List<ShoppingListItem>
) : DiffUtil.Callback() {

    override fun getOldListSize() = old.size

    override fun getNewListSize() = new.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        old[oldItemPosition].title == new[newItemPosition].title

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        old[oldItemPosition] == new[newItemPosition]
}