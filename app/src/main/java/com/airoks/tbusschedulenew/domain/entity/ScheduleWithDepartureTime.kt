package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ScheduleWithDepartureTime(
    @Embedded
    val schedule: Schedule,

    @Relation(
        parentColumn = "id",
        entityColumn = "scheduleId"
    )
    val departureTime: List<DepartureTime>
)
