package me.vponomarenko.shoppinglist.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.common.ViewModelFactory
import me.vponomarenko.shoppinglist.common.extensions.makeGone
import me.vponomarenko.shoppinglist.common.extensions.makeVisible
import me.vponomarenko.shoppinglist.common.extensions.observe
import me.vponomarenko.shoppinglist.common.extensions.showSnack
import me.vponomarenko.shoppinglist.list.R
import me.vponomarenko.shoppinglist.list.di.ListComponent
import me.vponomarenko.shoppinglist.list.recycler.ShoppingListAdapter
import me.vponomarenko.shoppinglist.list.viewmodel.ShoppingListViewModel
import me.vponomarenko.shoppinglist.list.viewstate.ShoppingListViewState
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class ShoppingListFragment : Fragment(), IHasComponent<ListComponent> {

    @Inject
    internal lateinit var adapter: ShoppingListAdapter

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(ShoppingListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        XInjectionManager.bindComponent(this).inject(this)
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        adapter.onClickListener = viewModel::onItemChecked
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_list, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = this@ShoppingListFragment.adapter
            (itemAnimator as? DefaultItemAnimator)?.supportsChangeAnimations = false
        }
        viewModel.viewState.observe(this) {
            when (it) {
                is ShoppingListViewState.Loading -> progress_list.makeVisible()
                is ShoppingListViewState.Loaded -> {
                    progress_list.makeGone()
                    adapter.update(it.items)
                }
                is ShoppingListViewState.Error -> {
                    progress_list.makeGone()
                    view.showSnack(it.message, errorAction = it.errorAction)
                }
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_edit -> {
                viewModel.onEditClick()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getComponent() = ListComponent.init()
}