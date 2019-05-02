package com.github.teren4m.fossil.navigator.core

import com.github.teren4m.fossil.navigator.core.location.ILocationHelper
import com.github.teren4m.fossil.navigator.core.location.LocationHelper
import dagger.Binds
import dagger.Module

@Module
abstract class CoreModule {

    @Binds
    abstract fun bindLocationHelper(locationHelper: LocationHelper): ILocationHelper

}