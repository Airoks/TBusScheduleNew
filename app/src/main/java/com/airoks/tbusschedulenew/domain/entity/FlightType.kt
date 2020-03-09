package com.airoks.tbusschedulenew.domain.entity

import com.google.gson.annotations.SerializedName

enum class FlightType(val id: Int) {
    @SerializedName("0")
    URBAN(0),
    @SerializedName("1")
    SUBURBAN(1)
}
