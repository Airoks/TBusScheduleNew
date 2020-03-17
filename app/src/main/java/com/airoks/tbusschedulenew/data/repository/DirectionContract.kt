package com.airoks.tbusschedulenew.data.repository

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Direction
import com.airoks.tbusschedulenew.domain.entity.DirectionWithRouts

interface DirectionContract {

    interface DataSource {
        suspend fun saveDirections(directions: List<Direction>)
        suspend fun getDirectionById(id: Long): Result<Direction>
        suspend fun getFlightIdByDirectionId(id: Long): Result<Long>
        suspend fun getRoutByDirectionId(id: Long): Result<DirectionWithRouts>
    }

    interface Repository {

    }
}
