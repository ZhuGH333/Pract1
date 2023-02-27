package dadm.zyang.practica1.ui.newquotation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewQuotationViewModel: ViewModel(){
    private val userNamPrivate = MutableLiveData<String>(getUserName())
    private fun getUserName()=setOf("Alice", "Bob","Charlie", "David", "Emma").random()

    val userName : LiveData<String> = userNamPrivate
}