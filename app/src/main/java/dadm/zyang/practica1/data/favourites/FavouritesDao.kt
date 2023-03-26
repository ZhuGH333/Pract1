package dadm.zyang.practica1.data.favourites

import androidx.room.*

import dadm.zyang.practica1.data.favourites.FavouritesContract.FavouriteEntry.COLUMN_ID
import dadm.zyang.practica1.data.favourites.FavouritesContract.FavouriteEntry.TABLE_NAME
import dadm.zyang.practica1.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

@Dao
interface FavouritesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addQuotation(quotation: QuotationDto)

    @Delete
    suspend fun removeQuotation(quotation: QuotationDto)

    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllQuotations(): Flow<List<QuotationDto>>

    @Query("SELECT * FROM $TABLE_NAME WHERE $COLUMN_ID = :id")
    fun getQuotationById(id: String): Flow<QuotationDto>

    @Query("DELETE FROM $TABLE_NAME")
    suspend fun clearAllQuotations()
}