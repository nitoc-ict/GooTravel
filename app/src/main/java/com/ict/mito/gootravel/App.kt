package com.ict.mito.gootravel

import android.app.Application
import com.ict.mito.gootravel.db.RegisterDataRoomDataBase
import com.ict.mito.gootravel.disaster.manual.ui.ManualViewModel
import com.ict.mito.gootravel.repo.Repository
import com.ict.mito.gootravel.repo.impl.RepositoryImpl
import com.ict.mito.gootravel.spot.model.LocationLiveData
import com.ict.mito.gootravel.spot.model.OrientationLiveData
import com.ict.mito.gootravel.spot.navigate.ui.NavigateViewModel
import com.ict.mito.gootravel.spot.register.ui.RegisterViewModel
import com.ict.mito.gootravel.spot.select.list.ui.ListViewModel
import com.ict.mito.gootravel.spot.select.radar.ui.RadarViewModel
import com.ict.mito.gootravel.spot.select.search.ui.SearchViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.context.startKoin
import org.koin.core.module.Module
import org.koin.dsl.module

/**
 * Created by mitohato14 on 2019-07-25.
 */
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(
                arrayListOf(
                    viewModelModule,
                    liveDataModule,
                    databaseModule,
                    repositoryModule
                )
            )
        }
    }

    private val viewModelModule: Module = module {
        viewModel { ManualViewModel() }
        viewModel {
            NavigateViewModel(
                get(),
                get()
            )
        }
        viewModel { RegisterViewModel() }
        viewModel { ListViewModel() }
        viewModel { RadarViewModel() }
        viewModel { SearchViewModel() }
    }

    private val liveDataModule: Module = module {
        factory { OrientationLiveData(applicationContext) }
        factory { LocationLiveData(applicationContext) }
    }

    private val databaseModule: Module = module {
        single { RegisterDataRoomDataBase.getDataBase(applicationContext) }
        single { get<RegisterDataRoomDataBase>().dao() }
    }

    private val repositoryModule: Module = module {
        single { RepositoryImpl(get()) as Repository }
    }
}
