package com.airoks.tbusschedulenew.domain.entity

import com.google.gson.annotations.SerializedName

enum class DirectionType(val id: Int) {
    @SerializedName("0")
    DIRECT(0),
    @SerializedName("1")
    REVERSE(1)
}
