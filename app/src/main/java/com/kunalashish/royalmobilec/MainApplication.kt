package com.kunalashish.royalmobilec

import android.app.Application
import com.onesignal.OneSignal

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)

        OneSignal.initWithContext(this)
        OneSignal.setAppId("ca8d63bf-88fb-4eab-acec-23b9362d5a03")
    }
}