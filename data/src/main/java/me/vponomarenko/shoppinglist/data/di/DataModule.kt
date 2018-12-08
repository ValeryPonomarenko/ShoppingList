package me.vponomarenko.shoppinglist.data.di

import com.google.firebase.database.FirebaseDatabase
import dagger.Module
import dagger.Provides
import me.vponomarenko.shoppinglist.data.ShoppingListRepositoryImpl
import me.vponomarenko.shoppinglist.data.datasources.FirebaseDbDataSource
import me.vponomarenko.shoppinglist.data.datasources.ShoppingListDataSource
import me.vponomarenko.shoppinglist.data.mappers.DataShoppingListItemMapper
import me.vponomarenko.shoppinglist.data.mappers.FirebaseMapper
import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class DataModule {
    @Singleton
    @Provides
    fun provideFirebase(): FirebaseDatabase = FirebaseDatabase.getInstance()

    @Singleton
    @Provides
    fun provideRepository(repository: ShoppingListRepositoryImpl): ShoppingListRepository = repository

    @Singleton
    @Provides
    fun provideDataSource(firebaseDbDataSource: FirebaseDbDataSource): ShoppingListDataSource = firebaseDbDataSource

    @Singleton
    @Provides
    fun provideFirebaseMapper(): FirebaseMapper = FirebaseMapper()

    @Singleton
    @Provides
    fun provideDataShoppingListItemMapper(): DataShoppingListItemMapper = DataShoppingListItemMapper()
}