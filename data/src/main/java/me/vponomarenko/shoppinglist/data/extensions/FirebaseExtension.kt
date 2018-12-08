package me.vponomarenko.shoppinglist.data.extensions

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import io.reactivex.Observable

/**
 * Author: Valery Ponomarenko
 * Date: 08/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

internal fun <T> DatabaseReference.asObservable(mapper: (DataSnapshot) -> T): Observable<T> =
    Observable.create { emitter ->
        val listener = object : ValueEventListener {
            override fun onCancelled(error: DatabaseError) {
                emitter.onError(error.toException())
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                emitter.onNext(mapper(snapshot))
            }
        }
        addValueEventListener(listener)
        emitter.setCancellable { removeEventListener(listener) }
    }