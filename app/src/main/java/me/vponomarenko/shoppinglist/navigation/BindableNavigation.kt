package me.vponomarenko.shoppinglist.navigation

import androidx.navigation.NavController

interface BindableNavigation {
    fun bind(navController: NavController)

    fun unbind()
}