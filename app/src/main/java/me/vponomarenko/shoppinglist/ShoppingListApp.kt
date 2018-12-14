package me.vponomarenko.shoppinglist

import android.app.Application
import com.google.firebase.FirebaseApp
import me.vponomarenko.injectionmanager.IHasComponent
import me.vponomarenko.injectionmanager.x.XInjectionManager
import me.vponomarenko.shoppinglist.data.di.DaggerDataComponent
import me.vponomarenko.shoppinglist.data.di.DataComponent
import me.vponomarenko.shoppinglist.di.AppComponent
import me.vponomarenko.shoppinglist.domain.di.DaggerDomainComponent
import me.vponomarenko.shoppinglist.domain.di.DomainComponent

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class ShoppingListApp : Application(), IHasComponent<AppComponent> {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
        XInjectionManager.init(this)
        initAppComponents()
    }

    override fun getComponent() = AppComponent.init()

    private fun initAppComponents() {
        XInjectionManager.apply {
            bindComponent(this@ShoppingListApp)
            bindComponentToCustomLifecycle(object : IHasComponent<DataComponent> {
                override fun getComponent(): DataComponent = DaggerDataComponent.create()
            })
            bindComponentToCustomLifecycle(object : IHasComponent<DomainComponent> {
                override fun getComponent(): DomainComponent =
                    DaggerDomainComponent.builder()
                        .domainDataDeps(XInjectionManager.findComponent())
                        .domainSchedulersDeps(XInjectionManager.findComponent())
                        .build()
            })
        }
    }
}