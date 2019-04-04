package com.github.teren4m.words.words.create

import dagger.Subcomponent
import dagger.android.AndroidInjector

@Subcomponent(
    modules = [
        CreateWordFragmentModule::class
    ]
)
interface CreateWordFragmentComponent : AndroidInjector<CreateWordFragment> {
    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<CreateWordFragment>()
}