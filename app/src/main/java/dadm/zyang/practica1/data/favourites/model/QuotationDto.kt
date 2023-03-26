package dadm.zyang.practica1.data.favourites.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

import dadm.zyang.practica1.data.favourites.FavouritesContract
import dadm.zyang.practica1.data.favourites.FavouritesContract.FavouriteEntry.TABLE_NAME
import dadm.zyang.practica1.domain.model.Quotation

@Entity(tableName = TABLE_NAME)
data class QuotationDto(
    @PrimaryKey
    @ColumnInfo(name = FavouritesContract.FavouriteEntry.COLUMN_ID)
    val id: String,

    @ColumnInfo(name = FavouritesContract.FavouriteEntry.COLUMN_TEXT)
    val cita: String,

    @ColumnInfo(name = FavouritesContract.FavouriteEntry.COLUMN_AUTHOR)
    val author: String
)