package com.example.rickandmortyapp.di.component

import com.example.rickandmortyapp.MyApp
import com.example.rickandmortyapp.di.module.ActivityMainBindingModule
import com.example.rickandmortyapp.di.module.ApiModule
import com.example.rickandmortyapp.di.module.AppModule
import com.example.rickandmortyapp.di.module.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityMainBindingModule::class,
        ApiModule::class,
        ViewModelModule::class
]
)
interface AppComponent : AndroidInjector<MyApp> {
    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(app: MyApp): Builder

        fun build(): AppComponent

    }

    override fun inject(app: MyApp)

    fun exposeApp(): MyApp
}