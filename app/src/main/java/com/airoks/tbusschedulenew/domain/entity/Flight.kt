package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Flight(
    @SerializedName("id")
    @PrimaryKey
    val id: Long,

    @SerializedName("flight_number")
    val flightNumber: String,

    @SerializedName("flight_type_fk")
    @Embedded(prefix = "type_")
    val flightType: FlightType
)
