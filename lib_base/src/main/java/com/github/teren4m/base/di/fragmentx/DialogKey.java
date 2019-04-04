package com.github.teren4m.base.di.fragmentx;

import android.app.Dialog;

import java.lang.annotation.Documented;
import java.lang.annotation.Target;

import dagger.MapKey;
import dagger.internal.Beta;

import static java.lang.annotation.ElementType.METHOD;

@Beta
@MapKey
@Documented
@Target(METHOD)
public @interface DialogKey {
    Class<? extends Dialog> value();
}

