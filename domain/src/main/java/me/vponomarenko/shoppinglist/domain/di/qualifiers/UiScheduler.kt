package me.vponomarenko.shoppinglist.domain.di.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class UiScheduler(val value: String = "UiScheduler")