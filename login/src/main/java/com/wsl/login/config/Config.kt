package com.wsl.login.config

import android.content.Context
import android.util.Log
import com.wsl.login.database.entities.EConfig
import org.json.JSONObject
import java.io.*
import java.lang.StringBuilder
import javax.inject.Inject

const val CONFIG_TAG = "WSL_CONFIG_FILE "
class Config @Inject constructor(
    private val context: Context
) {
    private var fileOutputStream: FileOutputStream =
        context.openFileOutput(WSL_CONFIG_FIlE_NAME, Context.MODE_PRIVATE)

    fun readConfigFile(): EConfig? {

        var config: EConfig? = null
        try {
            val inputStream = context.assets.open(WSL_CONFIG_FIlE_NAME)
            val inputString = inputStream.bufferedReader().use { it.readText() }

            Log.d(CONFIG_TAG, inputString)
            val configJson = JSONObject(inputString).getJSONObject(MAIN_PROJECT_KEY)

            config = EConfig(
                project_id = configJson.getString(PROJECT_ID_KEY),
                project_name = configJson.getString(PROJECT_NAME_KEY),
                project_icon = configJson.getString(PROJECT_ICON_KEY)
            )

        } catch (e: Exception){
            e.printStackTrace()
        }

        return config
    }

    fun saveConfigFile(configFile: String) {
        try {
            fileOutputStream.write(configFile.toByteArray())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
            //TODO: crear el file si no esta creado
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

}