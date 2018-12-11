package me.vponomarenko.shoppinglist

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.di.AppComponent
import me.vponomarenko.shoppinglist.navigation.BindableNavigation
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var navigationFacade: BindableNavigation

    @Inject
    internal lateinit var toolbarElevationMover: ToolbarElevationMover

    private val navController by lazy { findNavController(R.id.nav_host_fragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        XInjectionManager.findComponent<AppComponent>().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        toolbar.setupWithNavController(navController)
    }

    override fun onResume() {
        super.onResume()
        navigationFacade.bind(navController)
        toolbarElevationMover.bind(toolbar)
    }

    override fun onPause() {
        super.onPause()
        navigationFacade.unbind()
        toolbarElevationMover.unbind()
    }
}
