package me.vponomarenko.shoppinglist.di

import dagger.Component
import me.vponomarenko.shoppinglist.MainActivity
import me.vponomarenko.shoppinglist.domain.di.DomainSchedulersDepsIn
import me.vponomarenko.shoppinglist.edit.di.EditComponentDepsIn
import me.vponomarenko.shoppinglist.list.di.ShoppingListComponentDepsIn
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent : DomainSchedulersDepsIn, ShoppingListComponentDepsIn, EditComponentDepsIn {
    companion object {
        fun init(): AppComponent = DaggerAppComponent.create()
    }

    fun inject(activity: MainActivity)
}