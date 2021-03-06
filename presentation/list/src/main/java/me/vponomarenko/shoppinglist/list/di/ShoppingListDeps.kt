package me.vponomarenko.shoppinglist.list.di

import me.vponomarenko.shoppinglist.common.appearance.toolbarelevation.ToolbarElevationToggler
import me.vponomarenko.shoppinglist.list.navigation.ShoppingListNavigation

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface ShoppingListDeps {
    fun provideShoppingListNavigation(): ShoppingListNavigation
    fun provideToolbarElevationHelper(): ToolbarElevationToggler
}