package me.vponomarenko.shoppinglist.data.mappers

import me.vponomarenko.shoppinglist.data.data.DataShoppingListItem
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

/**
 * Author: Valery Ponomarenko
 * Date: 08/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class DataShoppingListItemMapper {
    fun createFrom(shoppingListItem: ShoppingListItem): DataShoppingListItem =
        DataShoppingListItem(shoppingListItem.id, shoppingListItem.title, shoppingListItem.isChecked)

    fun mapTo(dataShoppingListItem: DataShoppingListItem): ShoppingListItem =
        ShoppingListItem(dataShoppingListItem.id, dataShoppingListItem.title, dataShoppingListItem.checked)

    fun createFromList(items: List<ShoppingListItem>): List<DataShoppingListItem> =
        items.map(this::createFrom)

    fun mapToList(dataItems: List<DataShoppingListItem>): List<ShoppingListItem> =
        dataItems.map(this::mapTo)
}