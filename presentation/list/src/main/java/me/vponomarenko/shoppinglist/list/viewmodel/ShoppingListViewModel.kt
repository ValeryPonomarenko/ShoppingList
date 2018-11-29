package me.vponomarenko.shoppinglist.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import me.vponomarenko.shoppinglist.domain.entity.ShoppingListItem
import me.vponomarenko.shoppinglist.domain.usecases.LoadShoppingListUseCase
import me.vponomarenko.shoppinglist.domain.usecases.UpdateListItemUseCase
import me.vponomarenko.shoppinglist.list.viewstate.ShoppingListViewState
import javax.inject.Inject

class ShoppingListViewModel @Inject constructor(
    private val loadListUseCase: LoadShoppingListUseCase,
    private val updateItemUseCase: UpdateListItemUseCase
) : ViewModel() {

    private val disposables = CompositeDisposable()

    private val loadDisposable: Disposable? = null

    private val _viewModel = MutableLiveData<ShoppingListViewState>()

    val viewState: LiveData<ShoppingListViewState>
        get() = _viewModel

    init {
        val disposable = loadListUseCase()
            .subscribe({
                _viewModel.value = ShoppingListViewState.Loaded(it)
            }, {
                _viewModel.value = ShoppingListViewState.Error("Smth went wrong")
            })
        disposables.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        loadDisposable?.dispose()
    }

    fun onItemChecked(item: ShoppingListItem) {
        val disposable = updateItemUseCase(item)
            .doOnTerminate { disposables.remove(disposables) }
            .subscribe({

            }, {
                _viewModel.value = ShoppingListViewState.Error("Smth went wrong")
            })
        disposables.add(disposable)
    }
}