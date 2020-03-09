package com.airoks.tbusschedulenew.data.source.local.direction

import androidx.room.Dao
import androidx.room.Query
import com.airoks.tbusschedulenew.data.source.local.BaseDao
import com.airoks.tbusschedulenew.domain.entity.Direction
import com.airoks.tbusschedulenew.domain.entity.DirectionWithRouts

@Dao
interface DirectionDao : BaseDao<Direction> {

    @Query("SELECT * FROM Direction WHERE id = :id")
    suspend fun getDirectionById(id: Long): Direction?

    @Query("SELECT flightId FROM Direction WHERE id = :id")
    suspend fun getFlightIdByDirectionId(id: Long): Long?

    @Query("SELECT * FROM Direction WHERE id = :id")
    suspend fun getRoutByDirectionId(id: Long): DirectionWithRouts?
}
