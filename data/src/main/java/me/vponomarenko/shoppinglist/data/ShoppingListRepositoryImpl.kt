package me.vponomarenko.shoppinglist.data

import io.reactivex.Completable
import io.reactivex.Observable
import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository
import me.vponomarenko.shoppinglist.domain.entity.ListItem
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class ShoppingListRepositoryImpl @Inject constructor() : ShoppingListRepository {
    override fun loadShoppingList(): Observable<List<ListItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveShoppingList(list: List<ListItem>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateListItem(item: ListItem): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}