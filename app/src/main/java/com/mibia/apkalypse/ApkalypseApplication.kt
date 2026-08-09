package com.mibia.apkalypse

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ApkalypseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ApkalypseApplication)
            modules(emptyList())
        }
    }
}
