package me.vponomarenko.shoppinglist.di

import dagger.BindsInstance
import dagger.Component
import me.vponomarenko.shoppinglist.list.di.ShoppingListComponentDepsIn
import me.vponomarenko.shoppinglist.list.navigation.ShoppingListNavigation
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component
interface MainComponent : ShoppingListComponentDepsIn {
    companion object {
        fun init(navigation: ShoppingListNavigation): MainComponent =
            DaggerMainComponent.builder()
                .navigation(navigation)
                .build()
    }

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun navigation(nac: ShoppingListNavigation): Builder

        fun build(): MainComponent
    }
}