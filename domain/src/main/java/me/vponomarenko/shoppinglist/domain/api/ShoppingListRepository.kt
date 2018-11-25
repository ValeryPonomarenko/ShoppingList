package me.vponomarenko.shoppinglist.domain.api

import io.reactivex.Completable
import io.reactivex.Observable
import me.vponomarenko.shoppinglist.domain.entity.ListItem

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface ShoppingListRepository {
    fun loadShoppingList(): Observable<List<ListItem>>
    fun saveShoppingList(list: List<ListItem>): Completable
    fun updateListItem(item: ListItem): Completable
}