package me.vponomarenko.shoppinglist.edit.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import me.vponomarenko.shoppinglist.common.ErrorAction
import me.vponomarenko.shoppinglist.common.extensions.plusAssign
import me.vponomarenko.shoppinglist.domain.usecases.LoadShoppingListUseCase
import me.vponomarenko.shoppinglist.domain.usecases.SaveShoppingListUseCase
import me.vponomarenko.shoppinglist.edit.navigation.EditNavigation
import me.vponomarenko.shoppinglist.edit.viewstate.EditViewState
import javax.inject.Inject

class EditViewModel @Inject constructor(
    private val navigation: EditNavigation,
    private val saveShoppingListUseCase: SaveShoppingListUseCase,
    private val loadShoppingListUseCase: LoadShoppingListUseCase
) : ViewModel() {

    companion object {
        private const val NEW_LINE = "\n"
    }

    private val disposables = CompositeDisposable()

    private val _viewState = MutableLiveData<EditViewState>()

    val viewState: LiveData<EditViewState>
        get() = _viewState

    init {
        _viewState.value = EditViewState.Loading
        reload()
    }

    fun save(shoppingList: String) {
        _viewState.value = EditViewState.Loading
        disposables += saveShoppingListUseCase(shoppingList)
            .subscribe({
                navigation.backToList()
            }, {
                _viewState.value = EditViewState.Error(
                    "Error",
                    ErrorAction("Try again") { save(shoppingList) }
                )
            })
    }

    private fun reload() {
        disposables += loadShoppingListUseCase()
            .subscribe({
                _viewState.value = EditViewState.Loaded(it.joinToString(separator = NEW_LINE) { item -> item.title })
            }, {
                _viewState.value = EditViewState.Error(
                    "Error",
                    ErrorAction("Try again", this::reload)
                )
            })
    }
}