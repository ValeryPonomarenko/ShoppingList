package me.vponomarenko.shoppinglist.domain.di

import io.reactivex.Scheduler
import me.vponomarenko.shoppinglist.domain.di.qualifiers.IoScheduler
import me.vponomarenko.shoppinglist.domain.di.qualifiers.UiScheduler

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

interface DomainSchedulersDeps {
    @UiScheduler
    fun provideUiScheduler(): Scheduler
    @IoScheduler
    fun provideIoScheduler(): Scheduler
}