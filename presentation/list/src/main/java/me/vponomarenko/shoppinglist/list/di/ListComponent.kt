package me.vponomarenko.shoppinglist.list.di

import dagger.Component
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.domain.di.DomainDepsOut
import me.vponomarenko.shoppinglist.list.view.ShoppingListFragment
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [ShoppingListComponentDepsIn::class, DomainDepsOut::class],
    modules = [ListModule::class]
)
interface ListComponent {
    companion object {
        fun init(): ListComponent =
            DaggerListComponent.builder()
                .shoppingListComponentDepsIn(XInjectionManager.findComponent())
                .domainDepsOut(XInjectionManager.findComponent())
                .build()
    }

    fun inject(fragment: ShoppingListFragment)
}