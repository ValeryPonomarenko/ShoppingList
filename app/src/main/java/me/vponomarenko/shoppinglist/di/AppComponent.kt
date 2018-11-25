package me.vponomarenko.shoppinglist.di

import dagger.Component
import me.vponomarenko.shoppinglist.domain.di.DomainSchedulersDepsIn
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    modules = [AppModule::class]
)
interface AppComponent : DomainSchedulersDepsIn {
    companion object {
        fun init(): AppComponent = DaggerAppComponent.create()
    }
}