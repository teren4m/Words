package com.github.teren4m.base.di.fragmentx;

import android.app.Activity;
import android.app.Application;
import android.app.Dialog;
import android.util.Log;

import androidx.fragment.app.Fragment;
import dagger.android.AndroidInjector;
import dagger.internal.Beta;
import dagger.internal.Preconditions;

import static android.util.Log.DEBUG;

@Beta
public final class AndroidxInjection {
    private static final String TAG = "dagger.android.androidx";

    public static void inject(Fragment fragment) {
        Preconditions.checkNotNull(fragment, "fragment");
        HasAndroidxFragmentInjector hasAndroidxFragmentInjector = findHasFragmentInjector(fragment);
        if (Log.isLoggable(TAG, DEBUG)) {
            Log.d(
                    TAG,
                    String.format(
                            "An injector for %s was found in %s",
                            fragment.getClass().getCanonicalName(),
                            hasAndroidxFragmentInjector.getClass().getCanonicalName()));
        }

        AndroidInjector<Fragment> fragmentInjector =
                hasAndroidxFragmentInjector.androidxFragmentInjector();
        Preconditions.checkNotNull(
                fragmentInjector,
                "%s.supportFragmentInjector() returned null",
                hasAndroidxFragmentInjector.getClass());

        fragmentInjector.inject(fragment);
    }

    private static HasAndroidxFragmentInjector findHasFragmentInjector(Fragment fragment) {
        Fragment parentFragment = fragment;
        while ((parentFragment = parentFragment.getParentFragment()) != null) {
            if (parentFragment instanceof HasAndroidxFragmentInjector) {
                return (HasAndroidxFragmentInjector) parentFragment;
            }
        }
        Activity activity = fragment.getActivity();
        if (activity instanceof HasAndroidxFragmentInjector) {
            return (HasAndroidxFragmentInjector) activity;
        }
        if (activity.getApplication() instanceof HasAndroidxFragmentInjector) {
            return (HasAndroidxFragmentInjector) activity.getApplication();
        }
        throw new IllegalArgumentException(
                String.format("No injector was found for %s", fragment.getClass().getCanonicalName()));
    }

    private AndroidxInjection() {
    }
}