package me.vponomarenko.shoppinglist.edit.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_edit.*
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.common.ViewModelFactory
import me.vponomarenko.shoppinglist.common.extensions.makeGone
import me.vponomarenko.shoppinglist.common.extensions.makeVisible
import me.vponomarenko.shoppinglist.common.extensions.observe
import me.vponomarenko.shoppinglist.edit.R
import me.vponomarenko.shoppinglist.edit.di.EditComponent
import me.vponomarenko.shoppinglist.edit.viewmodel.EditViewModel
import me.vponomarenko.shoppinglist.edit.viewstate.EditViewState
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class EditFragment : Fragment(), IHasComponent<EditComponent> {

    @Inject
    internal lateinit var viewModelFactory: ViewModelFactory

    private val viewModel by lazy {
        ViewModelProviders.of(this, viewModelFactory).get(EditViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        XInjectionManager.bindComponent(this).inject(this)
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_edit, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.viewState.observe(this) {
            when (it) {
                is EditViewState.Loading -> progress_edit.makeVisible()
                is EditViewState.Loaded -> {
                    progress_edit.makeGone()
                    editText_list.setText(it.items)
                }
                is EditViewState.Error -> progress_edit.makeGone()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_edit, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_save -> {
                viewModel.save(editText_list.text.toString())
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getComponent() = EditComponent.init()
}