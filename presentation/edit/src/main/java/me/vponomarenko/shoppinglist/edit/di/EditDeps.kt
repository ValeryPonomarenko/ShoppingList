package me.vponomarenko.shoppinglist.edit.di

import me.vponomarenko.shoppinglist.common.appearance.toolbarelevation.ToolbarElevationToggler
import me.vponomarenko.shoppinglist.edit.navigation.EditNavigation

interface EditDeps {
    fun provideEditNavigation(): EditNavigation
    fun provideToolbarElevationHelper(): ToolbarElevationToggler
}