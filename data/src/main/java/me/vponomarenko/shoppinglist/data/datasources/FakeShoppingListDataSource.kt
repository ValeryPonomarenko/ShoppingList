package me.vponomarenko.shoppinglist.data.datasources

import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import me.vponomarenko.shoppinglist.data.data.DataShoppingListItem
import javax.inject.Inject

internal class FakeShoppingListDataSource @Inject constructor() : ShoppingListDataSource {

    private val items = mutableListOf<DataShoppingListItem>()

    private val publisher = PublishSubject.create<List<DataShoppingListItem>>()

    override fun loadShoppingList(): Observable<List<DataShoppingListItem>> {
        return publisher
    }

    override fun saveShoppingList(list: List<DataShoppingListItem>): Completable {
        items.clear()
        items.addAll(list)
        publisher.onNext(items)
        return Completable.complete()
    }

    override fun updateListItem(item: DataShoppingListItem): Completable {
        val index = items.indexOf(item)
        items.removeAt(index)
        items.add(index, item)
        return Completable.complete()
    }
}