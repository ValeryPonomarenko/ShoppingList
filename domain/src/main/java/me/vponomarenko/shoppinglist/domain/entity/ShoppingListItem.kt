package me.vponomarenko.shoppinglist.domain.entity

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

data class ShoppingListItem(
    val id: Int,
    val title: String,
    val isChecked: Boolean
)