package dadm.zyang.practica1.data.favourites

import dadm.zyang.practica1.domain.model.Quotation
import kotlinx.coroutines.flow.Flow

interface FavouritesRepository {
    suspend fun addQuotation(quotation: Quotation)
    suspend fun removeQuotation(quotation: Quotation)
    fun getAllQuotations(): Flow<List<Quotation>>
    fun getQuotationById(id: String): Flow<Quotation?>
    suspend fun clearAllQuotations()

}