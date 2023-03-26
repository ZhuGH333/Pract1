package dadm.zyang.practica1.data.settings

import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SettingsRepositoryImpl @Inject constructor(private val settingsDataSource: SettingsDataSource): SettingsRepository {
    override fun getUsername(): Flow<String> {
        return settingsDataSource.getUsername()
    }
}