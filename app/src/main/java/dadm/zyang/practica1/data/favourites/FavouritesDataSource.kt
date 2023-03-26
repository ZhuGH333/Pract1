package dadm.zyang.practica1.data.favourites

import dadm.zyang.practica1.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow

interface FavouritesDataSource {
    suspend fun addQuotation(quotation: QuotationDto)
    suspend fun removeQuotation(quotation: QuotationDto)
    fun getAllQuotations(): Flow<List<QuotationDto>>
    fun getQuotationById(id: String): Flow<QuotationDto?>
    suspend fun clearAllQuotations()
}