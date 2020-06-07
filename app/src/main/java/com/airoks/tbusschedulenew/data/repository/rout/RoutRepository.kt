package com.airoks.tbusschedulenew.data.repository.rout

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Rout
import com.airoks.tbusschedulenew.domain.entity.RoutsWithSchedule

class RoutRepository(
    private val dataSource: RoutDataSource
) {
    suspend fun saveRouts(routs: List<Rout>) =
        dataSource.saveRouts(routs)

    suspend fun getAllRouts(): Result<List<Rout>> =
        dataSource.getAllRouts()

    suspend fun getRoutByStopAndDirectionId(stopId: Long, directionId: Long): Result<Rout> =
        dataSource.getRoutByStopAndDirectionId(stopId, directionId)

    suspend fun getRoutIdByStopAndDirectionId(stopId: Long, directionId: Long): Result<Long> =
        dataSource.getRoutIdByStopAndDirectionId(stopId, directionId)

    suspend fun getScheduleByRoutId(id: Long): Result<RoutsWithSchedule> =
        dataSource.getScheduleByRoutId(id)
}
