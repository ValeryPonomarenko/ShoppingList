package me.vponomarenko.shoppinglist.common.di

import android.os.Build
import dagger.Module
import dagger.Provides
import me.vponomarenko.shoppinglist.common.appearance.toolbarelevation.ToolbarElevationSetter
import me.vponomarenko.shoppinglist.common.appearance.toolbarelevation.ToolbarElevationSetterImplNoOp
import me.vponomarenko.shoppinglist.common.appearance.toolbarelevation.ToolbarElevationSetterImplV23
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 13/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
class ToolbarElevationModule {
    @Provides
    @Singleton
    fun provideToolbarElevationSetter(
        elevationSetterNoOp: ToolbarElevationSetterImplNoOp,
        elevationSetterV23: ToolbarElevationSetterImplV23
    ): ToolbarElevationSetter =
        elevationSetterV23.takeIf { Build.VERSION.SDK_INT >= Build.VERSION_CODES.M } ?: elevationSetterNoOp
}