package me.vponomarenko.shoppinglist.navigation

import androidx.navigation.NavController
import me.vponomarenko.shoppinglist.R
import me.vponomarenko.shoppinglist.edit.navigation.EditNavigation
import me.vponomarenko.shoppinglist.list.navigation.ShoppingListNavigation
import java.util.concurrent.LinkedBlockingQueue

class NavigationFacade : BindableNavigation, ShoppingListNavigation, EditNavigation {

    private var navController: NavController? = null

    private val pendingCommands = LinkedBlockingQueue<NavController.() -> Unit>()

    override fun bind(navController: NavController) {
        this.navController = navController
        while (pendingCommands.isNotEmpty()) {
            pendingCommands.poll().invoke(navController)
        }
    }

    override fun unbind() {
        navController = null
    }

    override fun navigateToEdit() {
        navController?.navigate(R.id.action_shoppingListFragment_to_editFragment) ?: also {
            pendingCommands.add {
                navigate(R.id.action_shoppingListFragment_to_editFragment)
            }
        }
    }

    override fun backToList() {
        navController?.popBackStack() ?: also {
            pendingCommands.add {
                popBackStack()
            }
        }
    }
}