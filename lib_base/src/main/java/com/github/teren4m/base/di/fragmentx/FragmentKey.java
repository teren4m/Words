package com.github.teren4m.base.di.fragmentx;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import androidx.fragment.app.Fragment;
import dagger.MapKey;
import dagger.internal.Beta;

import static java.lang.annotation.ElementType.METHOD;

@Beta
@MapKey
@Documented
@Target(METHOD)
public @interface FragmentKey {
    Class<? extends Fragment> value();
}
