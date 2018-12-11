package me.vponomarenko.shoppinglist

import android.view.View
import me.vponomarenko.shoppinglist.common.ToolbarElevationHelper

/**
 * Author: Valery Ponomarenko
 * Date: 11/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class ToolbarElevationMover : ToolbarElevationHelper {

    private var toolbar: View? = null

    override fun showElevation(isShown: Boolean) {
        toolbar?.isSelected = isShown
    }

    fun bind(toolbar: View) {
        this.toolbar = toolbar
    }

    fun unbind() {
        toolbar = null
    }
}