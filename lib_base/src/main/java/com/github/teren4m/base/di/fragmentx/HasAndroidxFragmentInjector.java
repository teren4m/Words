package com.github.teren4m.base.di.fragmentx;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.internal.Beta;

@Beta
public interface HasAndroidxFragmentInjector {

    AndroidInjector<Fragment> androidxFragmentInjector();
}
