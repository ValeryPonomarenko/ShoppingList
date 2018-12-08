package me.vponomarenko.shoppinglist.data.mappers

import com.google.firebase.database.DataSnapshot
import me.vponomarenko.shoppinglist.data.data.DataShoppingListItem

/**
 * Author: Valery Ponomarenko
 * Date: 08/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class FirebaseMapper {
    fun mapTo(item: DataSnapshot): DataShoppingListItem =
        item.getValue(DataShoppingListItem::class.java)?.copy(id = item.key?.toInt() ?: -1) ?: throw ClassCastException()
}