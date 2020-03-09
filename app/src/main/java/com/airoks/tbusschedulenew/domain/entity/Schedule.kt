package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Schedule(
    @SerializedName("id")
    @PrimaryKey
    val id: Long,

    @SerializedName("stops_on_routs_fk")
    val stopsOnRoutId: Long,

    @SerializedName("schedule_type")
    @Embedded
    val scheduleType: ScheduleType
)
