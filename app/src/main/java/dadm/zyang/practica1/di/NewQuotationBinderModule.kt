package dadm.zyang.practica1.di

import dadm.zyang.practica1.data.newquotation.NewQuotationDataSource
import dadm.zyang.practica1.data.newquotation.NewQuotationDataSourceImpl
import dadm.zyang.practica1.data.newquotation.NewQuotationRepository
import dadm.zyang.practica1.data.newquotation.NewQuotationRepositoryImpl
import dadm.zyang.practica1.data.settings.NewQuotationManager
import dadm.zyang.practica1.data.settings.NewQuotationManagerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class NewQuotationBinderModule {
    @Binds
    abstract fun bindNewQuotationRepository(NewQuotationRepositoryImpl: NewQuotationRepositoryImpl): NewQuotationRepository
    @Binds
    abstract fun bindNewQuotationDataSource(NewQuotationDataSourceImpl: NewQuotationDataSourceImpl): NewQuotationDataSource
    @Binds
    abstract fun provideNewQuotationManager(newQuotationManagerImpl: NewQuotationManagerImpl): NewQuotationManager
}