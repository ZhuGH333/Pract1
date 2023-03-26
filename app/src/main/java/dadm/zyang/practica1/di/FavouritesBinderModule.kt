package dadm.zyang.practica1.di

import dadm.zyang.practica1.data.favourites.FavouritesDataSource
import dadm.zyang.practica1.data.favourites.FavouritesDataSourceImpl
import dadm.zyang.practica1.data.favourites.FavouritesRepository
import dadm.zyang.practica1.data.favourites.FavouritesRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class FavouritesBinderModule {
    @Binds
    abstract fun bindFavouritesRepository(favouritesRepositoryImpl: FavouritesRepositoryImpl): FavouritesRepository
    @Binds
    abstract fun bindFavouritesDataSource(favouritesDataSourceImpl: FavouritesDataSourceImpl): FavouritesDataSource
}