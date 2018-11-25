package me.vponomarenko.shoppinglist.domain.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository
import me.vponomarenko.shoppinglist.domain.di.qualifiers.IoScheduler
import me.vponomarenko.shoppinglist.domain.di.qualifiers.UiScheduler
import me.vponomarenko.shoppinglist.domain.usecases.LoadShoppingListUseCase
import me.vponomarenko.shoppinglist.domain.usecases.SaveShoppingListUseCase
import me.vponomarenko.shoppinglist.domain.usecases.UpdateListItemUseCase
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class DomainModule {
    @Singleton
    @Provides
    fun provideLoadUseCase(
        repository: ShoppingListRepository,
        @UiScheduler uiScheduler: Scheduler,
        @IoScheduler ioScheduler: Scheduler
    ): LoadShoppingListUseCase = LoadShoppingListUseCase(repository, uiScheduler, ioScheduler)

    @Singleton
    @Provides
    fun provideSaveUseCase(
        repository: ShoppingListRepository,
        @UiScheduler uiScheduler: Scheduler,
        @IoScheduler ioScheduler: Scheduler
    ): SaveShoppingListUseCase = SaveShoppingListUseCase(repository, uiScheduler, ioScheduler)

    @Singleton
    @Provides
    fun provideUpdateUseCase(
        repository: ShoppingListRepository,
        @UiScheduler uiScheduler: Scheduler,
        @IoScheduler ioScheduler: Scheduler
    ): UpdateListItemUseCase = UpdateListItemUseCase(repository, uiScheduler, ioScheduler)
}