package me.vponomarenko.shoppinglist.list.viewstate

import me.vponomarenko.shoppinglist.common.ErrorAction
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

sealed class ShoppingListViewState {
    object Loading : ShoppingListViewState()
    data class Loaded(val items: List<ShoppingListItem>) : ShoppingListViewState()
    data class Error(val message: String, val errorAction: ErrorAction? = null) : ShoppingListViewState()
}