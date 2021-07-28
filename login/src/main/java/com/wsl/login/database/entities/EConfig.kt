package com.wsl.login.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "config")
data class EConfig(
    @PrimaryKey(autoGenerate = false)
    val project_id: String,
    val project_icon: String,
    val project_name: String
)