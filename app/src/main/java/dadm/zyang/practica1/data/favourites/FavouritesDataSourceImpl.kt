package dadm.zyang.practica1.data.favourites

import dadm.zyang.practica1.data.favourites.model.QuotationDto
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavouritesDataSourceImpl @Inject constructor(favouritesDao: FavouritesDao): FavouritesDataSource {
    private val favouritesDao = favouritesDao

    override suspend fun addQuotation(quotation: QuotationDto) {
        favouritesDao.addQuotation(quotation)
    }

    override suspend fun removeQuotation(quotation: QuotationDto) {
        favouritesDao.removeQuotation(quotation)
    }

    override fun getAllQuotations(): Flow<List<QuotationDto>> {
        return favouritesDao.getAllQuotations()
    }

    override fun getQuotationById(id: String): Flow<QuotationDto> {
        return favouritesDao.getQuotationById(id)
    }

    override suspend fun clearAllQuotations() {
        favouritesDao.clearAllQuotations()
    }
}