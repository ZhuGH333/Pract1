package dadm.zyang.practica1.data.settings

import kotlinx.coroutines.flow.Flow

interface SettingsRepository {
    fun getUsername(): Flow<String>
}