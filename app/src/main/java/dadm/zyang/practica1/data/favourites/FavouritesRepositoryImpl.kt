package dadm.zyang.practica1.data.favourites

import dadm.zyang.practica1.data.favourites.model.toDomainModel
import dadm.zyang.practica1.data.favourites.model.toDto
import dadm.zyang.practica1.domain.model.Quotation
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class FavouritesRepositoryImpl @Inject constructor(private val dataSource: FavouritesDataSource): FavouritesRepository {

    override suspend fun addQuotation(quotation: Quotation) {
        dataSource.addQuotation(quotation.toDto())
    }

    override suspend fun removeQuotation(quotation: Quotation) {
        dataSource.removeQuotation(quotation.toDto())
    }

    override fun getAllQuotations(): Flow<List<Quotation>> {

        return dataSource.getAllQuotations().map { list ->
            list.map { dto -> dto.toDomainModel() }
        }}

    override fun getQuotationById(id: String): Flow<Quotation> {
        return dataSource.getQuotationById(id)
            .map { dto -> dto.toDomainModel() }
    }

    override suspend fun clearAllQuotations() {
        dataSource.clearAllQuotations()
    }

}