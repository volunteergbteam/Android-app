package ru.nightgoat.volunteer

import com.facebook.stetho.Stetho
import com.google.android.libraries.places.api.Places
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import io.reactivex.exceptions.UndeliverableException
import io.reactivex.plugins.RxJavaPlugins
import net.danlew.android.joda.JodaTimeAndroid
import ru.nightgoat.volunteer.di.components.DaggerAppComponent
import timber.log.Timber
import java.net.UnknownHostException

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent
            .builder()
            .application(this)
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        JodaTimeAndroid.init(this)

        if (!Places.isInitialized()) Places.initialize(applicationContext, getString(R.string.google_api_key))

        RxJavaPlugins.setErrorHandler { throwable ->
            if (throwable is UndeliverableException && throwable.cause is UnknownHostException) {
                return@setErrorHandler // ignore BleExceptions as they were surely delivered at least once
            }
//            throw RuntimeException("Unexpected Throwable in RxJavaPlugins error handler", throwable)
        }
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
            Timber.plant(Timber.DebugTree())
        }

    }
}