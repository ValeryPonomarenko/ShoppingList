package me.vponomarenko.shoppinglist.common.extensions

import android.view.View

/**
 * Author: Valery Ponomarenko
 * Date: 11/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */
 
fun View.makeGone() {
    visibility = View.GONE
}

fun View.makeVisible() {
    visibility = View.VISIBLE
}