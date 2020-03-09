package com.airoks.tbusschedulenew.domain.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Stop(
    @SerializedName("id")
    @PrimaryKey
    val id: Long,

    @SerializedName("name_of_stop")
    val stopName: String
)
