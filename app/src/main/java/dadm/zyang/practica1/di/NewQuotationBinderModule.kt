package dadm.zyang.practica1.di

import dadm.zyang.practica1.data.newquotation.NewQuotationRepository
import dadm.zyang.practica1.data.newquotation.NewQuotationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun bindNewQuotationRepository(NewQuotationRepositoryImpl: NewQuotationRepositoryImpl): NewQuotationRepository
}