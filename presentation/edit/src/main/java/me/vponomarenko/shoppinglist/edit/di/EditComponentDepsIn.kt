package me.vponomarenko.shoppinglist.edit.di

import me.vponomarenko.shoppinglist.edit.navigation.EditNavigation

interface EditComponentDepsIn {
    fun provideEditNavigation(): EditNavigation
}