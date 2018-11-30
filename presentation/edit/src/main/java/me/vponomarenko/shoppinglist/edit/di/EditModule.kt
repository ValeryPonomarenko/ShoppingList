package me.vponomarenko.shoppinglist.edit.di

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import me.vponomarenko.shoppinglist.common.ViewModelKey
import me.vponomarenko.shoppinglist.edit.viewmodel.EditViewModel

@Module
internal abstract class EditModule {
    @Binds
    @IntoMap
    @ViewModelKey(EditViewModel::class)
    abstract fun provideEditViewModel(viewModel: EditViewModel): ViewModel
}