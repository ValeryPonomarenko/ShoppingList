package me.vponomarenko.shoppinglist.list.di

import dagger.Component
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.domain.di.DomainApi
import me.vponomarenko.shoppinglist.list.view.ShoppingListFragment
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [ShoppingListDeps::class, DomainApi::class],
    modules = [ListModule::class]
)
interface ListComponent {
    companion object {
        fun init(): ListComponent =
            DaggerListComponent.builder()
                .shoppingListDeps(XInjectionManager.findComponent())
                .domainApi(XInjectionManager.findComponent())
                .build()
    }

    fun inject(fragment: ShoppingListFragment)
}