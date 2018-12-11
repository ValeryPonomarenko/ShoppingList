package me.vponomarenko.shoppinglist.common

/**
 * Author: Valery Ponomarenko
 * Date: 11/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

data class ErrorAction(
    val actionTitle: String,
    val action: () -> Unit
)