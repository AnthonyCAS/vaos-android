package com.android.vaos.util.preference

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.android.vaos.util.EMPTY_STRING
import com.android.vaos.util.ext.getValue
import com.android.vaos.util.ext.setValue
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DataStoreManagerImp @Inject constructor(
    private val dataStore: DataStore<Preferences>
) : DataStoreManager {

    override suspend fun storeUserUUID(userUUID: String) = dataStore.setValue(USER_UUID, userUUID)

    override fun getUserUUID(): Flow<String> = dataStore.getValue(USER_UUID, EMPTY_STRING)

    override suspend fun storeUserName(userName: String) = dataStore.setValue(USER_NAME, userName)

    override fun getUserName(): Flow<String> = dataStore.getValue(USER_NAME, EMPTY_STRING)


    override suspend fun clearDataStore() {
        dataStore.edit {
            it.clear()
        }
    }

    companion object {
        val USER_UUID = stringPreferencesKey("com.android.vaos.secure_user_uuid")
        val USER_NAME = stringPreferencesKey("com.android.vaos.secure_user_name")
    }
}
