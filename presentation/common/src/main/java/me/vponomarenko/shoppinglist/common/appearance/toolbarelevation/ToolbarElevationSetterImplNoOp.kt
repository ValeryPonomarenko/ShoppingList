package me.vponomarenko.shoppinglist.common.appearance.toolbarelevation

import android.view.View
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 13/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class ToolbarElevationSetterImplNoOp @Inject constructor():
    ToolbarElevationSetter {

    override fun setWith(scrollableView: View) {
        //No op, because
    }
}