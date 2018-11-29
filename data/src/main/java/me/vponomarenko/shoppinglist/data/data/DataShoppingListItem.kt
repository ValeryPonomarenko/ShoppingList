package me.vponomarenko.shoppinglist.data.data

import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

internal data class DataShoppingListItem(val title: String) {
    constructor(shoppingListItem: ShoppingListItem) : this(shoppingListItem.title)

    fun toShoppingListItem() =
        ShoppingListItem(title, false)
}