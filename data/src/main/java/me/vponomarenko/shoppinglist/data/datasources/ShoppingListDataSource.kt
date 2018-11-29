package me.vponomarenko.shoppinglist.data.datasources

import io.reactivex.Completable
import io.reactivex.Observable
import me.vponomarenko.shoppinglist.data.data.DataShoppingListItem
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem

internal interface ShoppingListDataSource {
    fun loadShoppingList(): Observable<List<DataShoppingListItem>>
    fun saveShoppingList(list: List<DataShoppingListItem>): Completable
    fun updateListItem(item: DataShoppingListItem): Completable
}