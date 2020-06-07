package com.airoks.tbusschedulenew.data.repository.direction

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Direction
import com.airoks.tbusschedulenew.domain.entity.DirectionWithRouts

interface DirectionDataSource {
    suspend fun saveDirections(directions: List<Direction>)
    suspend fun getDirectionById(id: Long): Result<Direction>
    suspend fun getFlightIdByDirectionId(id: Long): Result<Long>
    suspend fun getRoutByDirectionId(id: Long): Result<DirectionWithRouts>
}
