package me.vponomarenko.shoppinglist.list.di

import androidx.lifecycle.ViewModel
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import me.vponomarenko.shoppinglist.common.ViewModelKey
import me.vponomarenko.shoppinglist.common.di.ToolbarElevationModule
import me.vponomarenko.shoppinglist.list.recycler.ShoppingListAdapter
import me.vponomarenko.shoppinglist.list.viewmodel.ShoppingListViewModel
import javax.inject.Singleton

@Module(includes = [ToolbarElevationModule::class])
internal class ListModule {
    @Singleton
    @Provides
    fun provideAdapter(): ShoppingListAdapter = ShoppingListAdapter()

    @Provides
    @IntoMap
    @ViewModelKey(ShoppingListViewModel::class)
    fun provideShoppingListViewModel(viewModel: ShoppingListViewModel): ViewModel = viewModel
}