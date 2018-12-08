package me.vponomarenko.shoppinglist.data.data

import com.google.firebase.database.Exclude

internal data class DataShoppingListItem(
    @Exclude
    val id: Int = -1,
    val title: String = "",
    val checked: Boolean = false
)