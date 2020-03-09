package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteStops(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val routId: Long
)
