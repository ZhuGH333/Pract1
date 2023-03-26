package dadm.zyang.practica1.ui.favourites

import androidx.lifecycle.*
import dadm.zyang.practica1.data.favourites.FavouritesRepository
import dadm.zyang.practica1.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FavouritesViewModel @Inject constructor(private val favouritesRepository: FavouritesRepository): ViewModel() {

    val listaFavs: LiveData<List<Quotation>> = favouritesRepository.getAllQuotations().asLiveData()

    val isDeleteAllVisible = Transformations.map(listaFavs) { it.isNotEmpty() }

    fun deleteAllQuotation(){
        viewModelScope.launch {
            favouritesRepository.clearAllQuotations()
        }
    }

    fun deleteQuotationAsPosition(position: Int){
        viewModelScope.launch {
            favouritesRepository.removeQuotation(listaFavs.value?.get(position)!!)
        }
    }
}