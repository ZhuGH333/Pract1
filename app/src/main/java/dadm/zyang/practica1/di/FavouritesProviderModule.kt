package dadm.zyang.practica1.di

import android.content.Context
import androidx.room.Room
import dadm.zyang.practica1.data.favourites.FavouritesContract
import dadm.zyang.practica1.data.favourites.FavouritesDao
import dadm.zyang.practica1.data.favourites.FavouritesDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class FavouritesProviderModule {
    @Provides
    @Singleton
    fun provideFavouritesDatabase(@ApplicationContext context: Context): FavouritesDatabase {
        return Room.databaseBuilder(
            context,
            FavouritesDatabase::class.java,
            FavouritesContract.DATABASE_NAME
        ).build()
    }

    @Provides
    fun provideFavouritesDao(database: FavouritesDatabase): FavouritesDao {
        return database.favouritesDao()
    }
}