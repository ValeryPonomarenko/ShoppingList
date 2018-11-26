package me.vponomarenko.shoppinglist.list.di

import dagger.Module
import dagger.Provides
import me.vponomarenko.shoppinglist.list.recycler.ShoppingListAdapter
import javax.inject.Singleton

@Module
internal class ListModule {
    @Singleton
    @Provides
    fun provideAdapter(): ShoppingListAdapter = ShoppingListAdapter()
}