package dadm.zyang.practica1.data.settings

import kotlinx.coroutines.flow.Flow


interface SettingsDataSource {
    fun getUsername(): Flow<String>
    fun getLanguage(): Flow<String>
}