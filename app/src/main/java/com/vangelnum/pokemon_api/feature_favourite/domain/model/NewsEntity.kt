package com.vangelnum.pokemon_api.feature_favourite.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "newsTable")
data class NewsEntity (
    @PrimaryKey(autoGenerate = false)
    val url: String,
    val time: String
)