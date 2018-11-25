package me.vponomarenko.shoppinglist.data.di

import dagger.Component
import me.vponomarenko.shoppinglist.domain.di.DomainDataDepsIn
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(modules = [DataModule::class])
interface DataComponent : DomainDataDepsIn