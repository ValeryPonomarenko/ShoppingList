package me.vponomarenko.shoppinglist.data.di

import dagger.Binds
import dagger.Module
import me.vponomarenko.shoppinglist.data.ShoppingListRepositoryImpl
import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal interface DataModule {
    @Singleton
    @Binds
    fun provideRepository(repository: ShoppingListRepositoryImpl): ShoppingListRepository
}