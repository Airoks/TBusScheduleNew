package com.airoks.tbusschedulenew.domain.entity

import com.google.gson.annotations.SerializedName

enum class ScheduleType(val id: Int) {
    @SerializedName("0")
    WORKDAY(0),
    @SerializedName("1")
    WEEKEND(1)
}
