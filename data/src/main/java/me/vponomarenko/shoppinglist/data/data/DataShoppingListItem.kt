package me.vponomarenko.shoppinglist.data.data

import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

internal data class DataShoppingListItem(val title: String, val checked: Boolean) {
    constructor(shoppingListItem: ShoppingListItem) : this(shoppingListItem.title, shoppingListItem.isChecked)

    fun toShoppingListItem() = ShoppingListItem(title, checked)
}