package me.vponomarenko.shoppinglist.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import me.vponomarenko.shoppinglist.common.extensions.plusAssign
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem
import me.vponomarenko.shoppinglist.domain.usecases.LoadShoppingListUseCase
import me.vponomarenko.shoppinglist.domain.usecases.UpdateListItemUseCase
import me.vponomarenko.shoppinglist.list.navigation.ShoppingListNavigation
import me.vponomarenko.shoppinglist.list.viewstate.ShoppingListViewState
import javax.inject.Inject

class ShoppingListViewModel @Inject constructor(
    loadListUseCase: LoadShoppingListUseCase,
    private val updateItemUseCase: UpdateListItemUseCase,
    private val navigation: ShoppingListNavigation
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val _viewModel = MutableLiveData<ShoppingListViewState>()

    val viewState: LiveData<ShoppingListViewState>
        get() = _viewModel

    init {
        disposables += loadListUseCase()
            .subscribe({
                _viewModel.value = ShoppingListViewState.Loaded(it)
            }, {
                _viewModel.value = ShoppingListViewState.Error("Smth went wrong")
            })
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
                _viewModel.value = ShoppingListViewState.Error("Smth went wrong")
            })
        disposables += disposable
    }

    fun onEditClick() {
        navigation.navigateToEdit()
    }
}