package dadm.zyang.practica1.di

import dadm.zyang.practica1.data.settings.SettingsDataSource
import dadm.zyang.practica1.data.settings.SettingsDataSourceImpl
import dadm.zyang.practica1.data.settings.SettingsRepository
import dadm.zyang.practica1.data.settings.SettingsRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class SettingsBinderModule {
     @Binds
     abstract fun bindSettingsRepository(settingsRepositoryImpl: SettingsRepositoryImpl): SettingsRepository

     @Binds
     abstract fun bindSettingsDataSource(settingsDataSourceImpl: SettingsDataSourceImpl): SettingsDataSource
}
