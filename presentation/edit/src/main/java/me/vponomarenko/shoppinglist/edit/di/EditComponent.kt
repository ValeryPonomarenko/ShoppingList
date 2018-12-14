package me.vponomarenko.shoppinglist.edit.di

import dagger.Component
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.domain.di.DomainApi
import me.vponomarenko.shoppinglist.edit.view.EditFragment
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [DomainApi::class, EditDeps::class],
    modules = [EditModule::class]
)
interface EditComponent {
    companion object {
        fun init(): EditComponent =
            DaggerEditComponent.builder()
                .domainApi(XInjectionManager.findComponent())
                .editDeps(XInjectionManager.findComponent())
                .build()
    }
    fun inject(fragment: EditFragment)
}