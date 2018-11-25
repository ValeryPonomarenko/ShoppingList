package me.vponomarenko.shoppinglist.domain.di.qualifiers

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IoScheduler(val value: String = "IoScheduler")