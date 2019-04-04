package com.github.teren4m.base.di.fragmentx;

import android.app.Dialog;

import java.util.Map;

import androidx.fragment.app.Fragment;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;
import dagger.internal.Beta;
import dagger.multibindings.Multibinds;

@Beta
@Module(includes = AndroidInjectionModule.class)
public abstract class AndroidxInjectionModule {
    @Multibinds
    abstract Map<Class<? extends Fragment>, AndroidInjector.Factory<? extends Fragment>>
    fragmentInjectorFactories();

    @Multibinds
    abstract Map<String, AndroidInjector.Factory<? extends Fragment>>
    fragmentInjectorFactoriesWithStringKeys();

    @Multibinds
    abstract Map<Class<? extends Dialog>, AndroidInjector.Factory<? extends Dialog>>
    dialogInjectorFactories();

    @Multibinds
    abstract Map<String, AndroidInjector.Factory<? extends Dialog>>
    dialogInjectorFactoriesWithStringKeys();

    private AndroidxInjectionModule() {
    }
}
