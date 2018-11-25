package me.vponomarenko.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import me.vponomarenko.shoppinglist.list.navigation.ShoppingListNavigation

class MainActivity : AppCompatActivity(), ShoppingListNavigation {

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController)
    }

    override fun navigateToEdit() {
        navController.navigate(R.id.action_shoppingListFragment_to_editFragment)
    }
}
