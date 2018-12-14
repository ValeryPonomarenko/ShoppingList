package me.vponomarenko.shoppinglist.domain.di

import me.vponomarenko.shoppinglist.domain.api.ShoppingListRepository

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface DomainDataDeps {
    fun provideRepository(): ShoppingListRepository
}