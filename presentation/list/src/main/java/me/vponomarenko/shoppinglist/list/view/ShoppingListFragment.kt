package me.vponomarenko.shoppinglist.list.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.list.R
import me.vponomarenko.shoppinglist.list.di.ListComponent
import me.vponomarenko.shoppinglist.list.navigation.ShoppingListNavigation
import javax.inject.Inject

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class ShoppingListFragment : Fragment(), IHasComponent<ListComponent> {

    @Inject
    internal lateinit var navigation: ShoppingListNavigation

    override fun onCreate(savedInstanceState: Bundle?) {
        XInjectionManager.bindComponent(this).inject(this)
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_list, container, false)

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_list, menu)
        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.option_edit -> {
                navigation.navigateToEdit()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun getComponent() = ListComponent.init()
}