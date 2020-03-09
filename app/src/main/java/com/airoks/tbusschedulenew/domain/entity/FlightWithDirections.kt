package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Embedded
import androidx.room.Relation

data class FlightWithDirections(
    @Embedded
    val flight: Flight,

    @Relation(
        parentColumn = "id",
        entityColumn = "flightId"
    )
    val directions: List<Direction>
)
