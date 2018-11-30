package me.vponomarenko.shoppinglist.edit.di

import dagger.Component
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.domain.di.DomainDepsOut
import me.vponomarenko.shoppinglist.edit.view.EditFragment
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [DomainDepsOut::class, EditComponentDepsIn::class],
    modules = [EditModule::class]
)
interface EditComponent {
    companion object {
        fun init(): EditComponent =
            DaggerEditComponent.builder()
                .domainDepsOut(XInjectionManager.findComponent())
                .editComponentDepsIn(XInjectionManager.findComponent())
                .build()
    }
    fun inject(fragment: EditFragment)
}