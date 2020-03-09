package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Embedded
import androidx.room.Relation

data class DirectionWithRouts(
    @Embedded
    val direction: Direction,

    @Relation(
        parentColumn = "id",
        entityColumn = "directionId"
    )
    val routs: List<Rout>
)
