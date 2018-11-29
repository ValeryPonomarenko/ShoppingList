package me.vponomarenko.shoppinglist.domain.usecases

import io.reactivex.Completable
import io.reactivex.Scheduler
import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class SaveShoppingListUseCase(
    private val repository: ShoppingListRepository,
    private val uiScheduler: Scheduler,
    private val ioScheduler: Scheduler
) {
    companion object {
        private const val LIST_DELIMITER = "\n"
    }

    operator fun invoke(list: String): Completable =
        repository.saveShoppingList(list.split(LIST_DELIMITER).map { ShoppingListItem(it, false) })
            .subscribeOn(ioScheduler)
            .observeOn(uiScheduler)
}