package me.vponomarenko.shoppinglist.data.datasources

import com.google.firebase.database.FirebaseDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import me.vponomarenko.shoppinglist.data.data.DataShoppingListItem
import me.vponomarenko.shoppinglist.data.extensions.asObservable
import me.vponomarenko.shoppinglist.data.mappers.FirebaseMapper
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class FirebaseDbDataSource @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase,
    private val firebaseMapper: FirebaseMapper
) : ShoppingListDataSource {

    companion object {
        private const val DB_NAME = "shoppinglist"
        private const val CHECKED_FIELD = "checked"
    }

    override fun loadShoppingList(): Observable<List<DataShoppingListItem>> =
        firebaseDatabase.getReference(DB_NAME)
            .asObservable {
                it.children.map(firebaseMapper::mapTo)
            }

    override fun saveShoppingList(list: List<DataShoppingListItem>): Completable =
        Completable.fromCallable {
            firebaseDatabase.getReference(DB_NAME)
                .setValue(list)
        }

    override fun updateListItem(item: DataShoppingListItem): Completable =
        Completable.fromCallable {
            firebaseDatabase.getReference(DB_NAME)
                .child(item.id.toString())
                .child(CHECKED_FIELD)
                .setValue(item.checked)
        }
}