package me.vponomarenko.shoppinglist.domain.di

import dagger.Component
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Singleton
@Component(
    dependencies = [DomainDataDeps::class, DomainSchedulersDeps::class],
    modules = [DomainModule::class]
)
interface DomainComponent: DomainApi