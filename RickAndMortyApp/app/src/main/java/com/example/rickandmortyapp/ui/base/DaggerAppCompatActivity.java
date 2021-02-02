package com.example.rickandmortyapp.ui.base;

import android.os.Bundle;
import androidx.annotation.ContentView;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasAndroidInjector;
import dagger.internal.Beta;
import javax.inject.Inject;

/**
 * An {@link AppCompatActivity} that injects its members in {@link #onCreate(Bundle)} and can be
 * used to inject {@code Fragment}s attached to it.
 */
@Beta
public abstract class DaggerAppCompatActivity extends AppCompatActivity
        implements HasAndroidInjector {

    @Inject DispatchingAndroidInjector<Object> androidInjector;

    public DaggerAppCompatActivity() {
        super();
    }

    @ContentView
    public DaggerAppCompatActivity(@LayoutRes int contentLayoutId) {
        super(contentLayoutId);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    public AndroidInjector<Object> androidInjector() {
        return androidInjector;
    }
}