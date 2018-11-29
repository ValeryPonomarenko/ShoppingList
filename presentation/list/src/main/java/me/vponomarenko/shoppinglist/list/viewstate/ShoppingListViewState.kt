package me.vponomarenko.shoppinglist.list.viewstate

import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

sealed class ShoppingListViewState {
    object Loading : ShoppingListViewState()
    data class Loaded(val items: List<ShoppingListItem>) : ShoppingListViewState()
    data class Error(val message: String) : ShoppingListViewState()
}