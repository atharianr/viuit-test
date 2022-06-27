package com.atharianr.viuit.di

import androidx.room.Room
import com.atharianr.viuit.data.source.ListRepository
import com.atharianr.viuit.data.source.local.LocalDataSource
import com.atharianr.viuit.data.source.local.room.Database
import com.atharianr.viuit.data.source.remote.LoginRepository
import com.atharianr.viuit.data.source.remote.RemoteDataSource
import com.atharianr.viuit.data.source.remote.network.ApiService
import com.atharianr.viuit.ui.list.ListViewModel
import com.atharianr.viuit.ui.login.LoginViewModel
import com.atharianr.viuit.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.API_BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val daoModule = module {
    single {
        Room.databaseBuilder(
            androidApplication(),
            Database::class.java,
            "viuit.db"
        ).fallbackToDestructiveMigration().build()
    }

    single {
        val database = get<Database>()
        database.dao()
    }
}

val remoteDataSourceModule = module {
    factory { RemoteDataSource(get()) }
}

val localDataSourceModule = module {
    factory { LocalDataSource(get()) }
}

val repositoryModule = module {
    factory { LoginRepository(get()) }
    factory { ListRepository(get(), get()) }
}

val viewModelModule = module {
    viewModel { LoginViewModel(get()) }
    viewModel { ListViewModel(get()) }
}