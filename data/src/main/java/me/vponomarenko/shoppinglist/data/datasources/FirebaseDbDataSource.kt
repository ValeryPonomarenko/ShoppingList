package me.vponomarenko.shoppinglist.data.datasources

import com.google.firebase.database.FirebaseDatabase
import io.reactivex.Completable
import io.reactivex.Observable
import me.vponomarenko.shoppinglist.data.data.DataShoppingListItem
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 01/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal class FirebaseDbDataSource @Inject constructor(
    private val firebaseDatabase: FirebaseDatabase
) : ShoppingListDataSource {
    companion object {
        private const val DB_NAME = "shoppinglist"
    }

    override fun loadShoppingList(): Observable<List<DataShoppingListItem>> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun saveShoppingList(list: List<DataShoppingListItem>): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateListItem(item: DataShoppingListItem): Completable {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}