package dadm.zyang.practica1.ui.newquotation

import androidx.lifecycle.*
import dadm.zyang.practica1.data.favourites.FavouritesRepository
import dadm.zyang.practica1.data.newquotation.NewQuotationRepository
import dadm.zyang.practica1.data.settings.NewQuotationManager
import dadm.zyang.practica1.data.settings.SettingsRepository
import dadm.zyang.practica1.domain.model.Quotation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewQuotationViewModel @Inject constructor(
    private val settingsRepository: SettingsRepository,
    private val newQuotationManager: NewQuotationManager,
    private val favouritesRepository: FavouritesRepository
    ): ViewModel(){
    private fun getUserName()=setOf("Alice", "Bob","Charlie", "David", "Emma").random()
    val userName : LiveData<String> = settingsRepository.getUsername().asLiveData()

    private val _cita = MutableLiveData<Quotation>()
    val cita : LiveData<Quotation> = _cita

    private val _isRefreshing = MutableLiveData<Boolean>()
    val isRefreshing : LiveData<Boolean> = _isRefreshing

    val isGreetingsVisible = Transformations.map(cita) { it == null }

    private val _showingButton = MutableLiveData<Boolean>()
    val showingButton : LiveData<Boolean> = _showingButton
    init {
        _showingButton.value = false
    }

    private val _error = MutableLiveData<Throwable?>()
    val error: LiveData<Throwable?> = _error

    fun resetError() {
        _error.value = null
    }

    fun getNewQuotation() {
        resetError()
        _isRefreshing.value = true

        viewModelScope.launch {
            newQuotationManager.getNewQuotation().fold(
                onSuccess = { quotation ->
                    _cita.value = quotation
                    _isRefreshing.value = false
                    _showingButton.value = true
                },
                onFailure = { error ->
                    _error.value = error
                    _isRefreshing.value = false
                }
            )
        }
    }


    fun addToFavourites(){
        viewModelScope.launch {
            favouritesRepository.addQuotation(cita.value!!)

            _showingButton.value = false
        }
    }
}
