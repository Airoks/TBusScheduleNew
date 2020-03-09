package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Direction (
    @SerializedName("id")
    @PrimaryKey
    val id: Long,

    @SerializedName("flight_fk")
    val flightId: Long,

    @SerializedName("direction_type_fk")
    @Embedded
    val directionType: DirectionType,

    @SerializedName("direction_name")
    val directionName: String
)

