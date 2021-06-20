package com.hafidrf.bareksaandroid_takehometest

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module
import com.hafidrf.bareksaandroid_takehometest.repo.IMainRepository
import com.hafidrf.bareksaandroid_takehometest.repo.MainRepository
import com.hafidrf.bareksaandroid_takehometest.ui.imbal_hasil.ImbalHasilViewModel
import com.hafidrf.bareksaandroid_takehometest.ui.main.MainViewModel

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            // Koin Android logger
            androidLogger()
            //inject Android context
            androidContext(this@App)
            // use modules
            modules(listModules())
        }
    }

    private fun listModules(): List<Module>{
        return listOf(
            module {
                single<IMainRepository> { MainRepository() }
                viewModel { MainViewModel(get()) }
                viewModel { ImbalHasilViewModel(get()) }
            }
        )
    }
}