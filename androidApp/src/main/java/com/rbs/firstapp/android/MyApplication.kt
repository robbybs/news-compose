package com.rbs.firstapp.android

import android.app.Application
import com.rbs.firstapp.android.di.databaseModule
import com.rbs.firstapp.android.di.viewModelModule
import com.rbs.firstapp.di.sharedKoinModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        val modules = sharedKoinModule + viewModelModule + databaseModule
        startKoin {
            androidContext(this@MyApplication)
            modules(modules)
        }
    }
}