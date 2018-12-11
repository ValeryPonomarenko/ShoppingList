package me.vponomarenko.shoppinglist.edit.viewstate

import me.vponomarenko.shoppinglist.common.ErrorAction

/**
 * Author: Valery Ponomarenko
 * Date: 11/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

sealed class EditViewState {
    object Loading : EditViewState()
    data class Loaded(val items: String) : EditViewState()
    data class Error(val message: String, val errorAction: ErrorAction? = null) : EditViewState()
}