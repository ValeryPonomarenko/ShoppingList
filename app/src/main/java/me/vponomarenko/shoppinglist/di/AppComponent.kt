package me.vponomarenko.shoppinglist.di

import dagger.Component
import me.vponomarenko.shoppinglist.MainActivity
import me.vponomarenko.shoppinglist.domain.di.DomainSchedulersDeps
import me.vponomarenko.shoppinglist.edit.di.EditDeps
import me.vponomarenko.shoppinglist.list.di.ShoppingListDeps
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
interface AppComponent : DomainSchedulersDeps, ShoppingListDeps, EditDeps {
    companion object {
        fun init(): AppComponent = DaggerAppComponent.create()
    }

    fun inject(activity: MainActivity)
}