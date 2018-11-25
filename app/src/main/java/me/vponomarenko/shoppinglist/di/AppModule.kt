package me.vponomarenko.shoppinglist.di

import dagger.Module
import dagger.Provides
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import me.vponomarenko.shoppinglist.domain.di.qualifiers.IoScheduler
import me.vponomarenko.shoppinglist.domain.di.qualifiers.UiScheduler
import javax.inject.Singleton

/**
 * Author: Valery Ponomarenko
 * Date: 25/11/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

@Module
internal class AppModule {
    @Singleton
    @Provides
    @UiScheduler
    fun provideUiScheduler(): Scheduler = AndroidSchedulers.mainThread()

    @Singleton
    @Provides
    @IoScheduler
    fun providerIoScheduler(): Scheduler = Schedulers.io()
}