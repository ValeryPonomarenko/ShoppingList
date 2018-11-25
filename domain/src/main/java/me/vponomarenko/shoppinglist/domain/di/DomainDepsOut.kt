package me.vponomarenko.shoppinglist.domain.di

import me.vponomarenko.shoppinglist.domain.usecases.LoadShoppingListUseCase
import me.vponomarenko.shoppinglist.domain.usecases.SaveShoppingListUseCase
import me.vponomarenko.shoppinglist.domain.usecases.UpdateListItemUseCase

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface DomainDepsOut {
    fun provideLoadUseCase(): LoadShoppingListUseCase
    fun provideSaveUseCase(): SaveShoppingListUseCase
    fun provideUpdateUseCase(): UpdateListItemUseCase
}