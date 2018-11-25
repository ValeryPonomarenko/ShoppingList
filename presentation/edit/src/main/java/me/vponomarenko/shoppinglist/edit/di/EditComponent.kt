package me.vponomarenko.shoppinglist.edit.di

import dagger.Component
import me.vponomarenko.shoppinglist.edit.view.EditFragment
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component
interface EditComponent {
    companion object {
        fun init(): EditComponent = DaggerEditComponent.create()
    }
    fun inject(fragment: EditFragment)
}