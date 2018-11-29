package me.vponomarenko.shoppinglist.domain.api

import io.reactivex.Completable
import io.reactivex.Observable
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface ShoppingListRepository {
    fun loadShoppingList(): Observable<List<ShoppingListItem>>
    fun saveShoppingList(list: List<ShoppingListItem>): Completable
    fun updateListItem(item: ShoppingListItem): Completable
}