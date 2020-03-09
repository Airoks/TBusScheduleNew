package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class DepartureTime(
    @PrimaryKey(autoGenerate = true)
    val id: Long,

    @SerializedName("schedule_fk")
    val scheduleId: Long,

    @SerializedName("hours")
    val hours: List<Int>,

    @SerializedName("time")
    val time: Map<Int, List<Int>>
)
