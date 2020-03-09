package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Rout(
    @SerializedName("id")
    @PrimaryKey
    val id: Long,

    @SerializedName("direction_fk")
    val directionId: Long,

    @SerializedName("stop_fk")
    val stopId: Long,

    @SerializedName("stop_position")
    val stopPosition: Int
)
