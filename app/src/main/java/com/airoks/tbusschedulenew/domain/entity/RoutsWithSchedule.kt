package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Embedded
import androidx.room.Relation

data class RoutsWithSchedule(
    @Embedded
    val rout: Rout,

    @Relation(
        parentColumn = "id",
        entityColumn = "stopsOnRoutId"
    )
    val schedule: List<Schedule>
)
