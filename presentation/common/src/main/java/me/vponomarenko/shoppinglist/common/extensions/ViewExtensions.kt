package me.vponomarenko.shoppinglist.common.extensions

import android.view.View
import com.google.android.material.snackbar.Snackbar
import me.vponomarenko.shoppinglist.common.ErrorAction

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

fun View.showSnack(message: String, duration: Int = Snackbar.LENGTH_LONG, errorAction: ErrorAction? = null) {
    Snackbar.make(this, message, duration)
        .apply {
            errorAction?.let { action ->
                setAction(action.actionTitle) { action.action() }
            }
        }
        .show()
}