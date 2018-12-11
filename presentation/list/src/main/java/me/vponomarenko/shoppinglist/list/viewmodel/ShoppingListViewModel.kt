package me.vponomarenko.shoppinglist.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import me.vponomarenko.shoppinglist.common.ErrorAction
import me.vponomarenko.shoppinglist.common.extensions.plusAssign
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem
import me.vponomarenko.shoppinglist.domain.usecases.LoadShoppingListUseCase
import me.vponomarenko.shoppinglist.domain.usecases.UpdateListItemUseCase
import me.vponomarenko.shoppinglist.list.navigation.ShoppingListNavigation
import me.vponomarenko.shoppinglist.list.viewstate.ShoppingListViewState
import javax.inject.Inject

class ShoppingListViewModel @Inject constructor(
    private val loadListUseCase: LoadShoppingListUseCase,
    private val updateItemUseCase: UpdateListItemUseCase,
    private val navigation: ShoppingListNavigation
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _viewModel = MutableLiveData<ShoppingListViewState>()

    val viewState: LiveData<ShoppingListViewState>
        get() = _viewModel

    init {
        load()
    }

    override fun onCleared() {
        super.onCleared()
        disposables.dispose()
    }

    fun onItemChecked(item: ShoppingListItem) {
        val disposable = updateItemUseCase(item)
            .doOnTerminate { disposables.remove(disposables) }
            .subscribe({

            }, {
                _viewModel.value = ShoppingListViewState.Error(
                    "Oops!",
                    ErrorAction("Try again") { onItemChecked(item) }
                )
            })
        disposables += disposable
    }

    fun onEditClick() {
        navigation.navigateToEdit()
    }

    private fun load() {
        _viewModel.value = ShoppingListViewState.Loading
        disposables += loadListUseCase()
            .subscribe({
                _viewModel.value = ShoppingListViewState.Loaded(it)
            }, {
                _viewModel.value = ShoppingListViewState.Error(
                    "Oops!",
                    ErrorAction("Try again", this::load)
                )
            })
    }
}