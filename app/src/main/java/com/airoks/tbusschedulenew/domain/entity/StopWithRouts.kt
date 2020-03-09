package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Embedded
import androidx.room.Relation

data class StopWithRouts(
    @Embedded
    val stop: Stop,

    @Relation(
        parentColumn = "id",
        entityColumn = "stopId"
    )
    val routs: List<Rout>
)
