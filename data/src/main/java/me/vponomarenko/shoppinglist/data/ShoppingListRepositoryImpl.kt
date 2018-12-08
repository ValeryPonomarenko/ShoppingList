package me.vponomarenko.shoppinglist.data

import io.reactivex.Completable
import io.reactivex.Observable
import me.vponomarenko.shoppinglist.data.datasources.ShoppingListDataSource
import me.vponomarenko.shoppinglist.data.mappers.DataShoppingListItemMapper
import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class ShoppingListRepositoryImpl @Inject constructor(
    private val dataSource: ShoppingListDataSource,
    private val dataShoppingListItemMapper: DataShoppingListItemMapper
) : ShoppingListRepository {
    override fun loadShoppingList(): Observable<List<ShoppingListItem>> =
        dataSource.loadShoppingList().map(dataShoppingListItemMapper::mapToList)

    override fun saveShoppingList(list: List<ShoppingListItem>): Completable =
        dataSource.saveShoppingList(dataShoppingListItemMapper.createFromList(list))

    override fun updateListItem(item: ShoppingListItem): Completable =
        dataSource.updateListItem(dataShoppingListItemMapper.createFrom(item))
}