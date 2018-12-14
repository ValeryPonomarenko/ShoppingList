package me.vponomarenko.shoppinglist.common.appearance.toolbarelevation

import android.annotation.TargetApi
import android.os.Build
import android.view.View
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 13/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class ToolbarElevationSetterImplV23 @Inject constructor(
    private val toolbarElevationShower: ToolbarElevationToggler
): ToolbarElevationSetter {

    companion object {
        private const val SCROLL_UPWARD = -1
    }

    @TargetApi(Build.VERSION_CODES.M)
    override fun setWith(scrollableView: View) {
        toolbarElevationShower.showElevation(scrollableView.canScrollVertically(SCROLL_UPWARD))
        scrollableView.setOnScrollChangeListener { _, _, _, _, _ ->
            toolbarElevationShower.showElevation(scrollableView.canScrollVertically(SCROLL_UPWARD))
        }
    }
}