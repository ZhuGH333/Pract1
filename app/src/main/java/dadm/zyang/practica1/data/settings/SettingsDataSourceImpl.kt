package dadm.zyang.practica1.data.settings

import android.content.SharedPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import javax.inject.Inject

class SettingsDataSourceImpl @Inject constructor(private val sharedPreferences: SharedPreferences) : SettingsDataSource {
    companion object {
        const val KEY_USERNAME = "username"
    }

    private fun getUsernamePreference() =sharedPreferences.getString(KEY_USERNAME, "") ?: ""

    override fun getUsername(): Flow<String> = callbackFlow {
        val listener = SharedPreferences.OnSharedPreferenceChangeListener { _, key ->
            launch(Dispatchers.IO) {
                if(key == KEY_USERNAME)
                    trySend(getUsernamePreference())
            }
        }
        sharedPreferences.registerOnSharedPreferenceChangeListener(listener)
        trySend(getUsernamePreference())
        awaitClose {
            sharedPreferences.unregisterOnSharedPreferenceChangeListener(listener) }
    }.flowOn(Dispatchers.IO)
}