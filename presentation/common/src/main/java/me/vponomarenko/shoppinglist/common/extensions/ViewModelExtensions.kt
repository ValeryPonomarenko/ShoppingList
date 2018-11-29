package me.vponomarenko.shoppinglist.common.extensions

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer

inline fun <reified T> LiveData<T>.observe(owner: LifecycleOwner, crossinline block: (T) -> Unit) {
    observe(owner, Observer { block(it) })
}