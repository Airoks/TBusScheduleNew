package com.airoks.tbusschedulenew.data.repository.direction

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Direction
import com.airoks.tbusschedulenew.domain.entity.DirectionWithRouts

class DirectionRepository(
    private val dataSource: DirectionDataSource
) {
    suspend fun saveDirections(directions: List<Direction>) =
        dataSource.saveDirections(directions)

    suspend fun getDirectionById(id: Long): Result<Direction> =
        dataSource.getDirectionById(id)

    suspend fun getFlightIdByDirectionId(id: Long): Result<Long> =
        dataSource.getFlightIdByDirectionId(id)

    suspend fun getRoutByDirectionId(id: Long): Result<DirectionWithRouts> =
        dataSource.getRoutByDirectionId(id)
}
