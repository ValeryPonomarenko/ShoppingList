package me.vponomarenko.shoppinglist.edit.viewmodel

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import me.vponomarenko.shoppinglist.common.extensions.plusAssign
import me.vponomarenko.shoppinglist.domain.usecases.SaveShoppingListUseCase
import me.vponomarenko.shoppinglist.edit.navigation.EditNavigation
import javax.inject.Inject

class EditViewModel @Inject constructor(
    private val navigation: EditNavigation,
    private val saveShoppingListUseCase: SaveShoppingListUseCase
) : ViewModel() {
    private val disposables = CompositeDisposable()

    fun save(shoppingList: String) {
        disposables += saveShoppingListUseCase(shoppingList)
            .subscribe({
                navigation.backToList()
            }, {

            })
    }
}