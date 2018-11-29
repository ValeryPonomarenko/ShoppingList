package me.vponomarenko.shoppinglist.data

import io.reactivex.Completable
import io.reactivex.Observable
import me.vponomarenko.shoppinglist.data.data.DataShoppingListItem
import me.vponomarenko.shoppinglist.data.datasources.ShoppingListDataSource
import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class ShoppingListRepositoryImpl @Inject constructor(
    private val dataSource: ShoppingListDataSource
) : ShoppingListRepository {
    override fun loadShoppingList(): Observable<List<ShoppingListItem>> =
        dataSource.loadShoppingList().map { items -> items.map { it.toShoppingListItem() } }

    override fun saveShoppingList(list: List<ShoppingListItem>): Completable =
        dataSource.saveShoppingList(list.map { DataShoppingListItem(it) })

    override fun updateListItem(item: ShoppingListItem): Completable =
        dataSource.updateListItem(DataShoppingListItem(item))
}