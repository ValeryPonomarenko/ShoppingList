package me.vponomarenko.shoppinglist.domain.usecases

import io.reactivex.Observable
import io.reactivex.Scheduler
import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class LoadShoppingListUseCase(
    private val repository: ShoppingListRepository,
    private val uiScheduler: Scheduler,
    private val ioScheduler: Scheduler
) {
    operator fun invoke(): Observable<List<ShoppingListItem>> =
        repository.loadShoppingList()
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
}