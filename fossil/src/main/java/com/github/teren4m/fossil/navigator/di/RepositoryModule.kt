package com.github.teren4m.fossil.navigator.di

import com.github.teren4m.fossil.navigator.data.FossilRemoteRepository
import com.github.teren4m.fossil.navigator.data.IFossilRemoteRepository
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {

    @Binds
    abstract fun bindFossilRemoteRepository(fossilRemoteRepository: FossilRemoteRepository): IFossilRemoteRepository

}