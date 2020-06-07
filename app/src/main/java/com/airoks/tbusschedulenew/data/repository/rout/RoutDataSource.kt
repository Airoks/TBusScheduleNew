package com.airoks.tbusschedulenew.data.repository.rout

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Rout
import com.airoks.tbusschedulenew.domain.entity.RoutsWithSchedule

interface RoutDataSource {
    suspend fun saveRouts(routs: List<Rout>)
    suspend fun getAllRouts(): Result<List<Rout>>
    suspend fun getRoutByStopAndDirectionId(stopId: Long, directionId: Long): Result<Rout>
    suspend fun getRoutIdByStopAndDirectionId(stopId: Long, directionId: Long): Result<Long>
    suspend fun getScheduleByRoutId(id: Long): Result<RoutsWithSchedule>
}
