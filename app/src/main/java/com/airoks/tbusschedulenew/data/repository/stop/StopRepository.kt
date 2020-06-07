package com.airoks.tbusschedulenew.data.repository.stop

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Stop
import com.airoks.tbusschedulenew.domain.entity.StopWithRouts

class StopRepository(
    private val dataSource: StopDataSource
) {
    suspend fun saveStops(stops: List<Stop>) =
        dataSource.saveStops(stops)

    suspend fun getAllStops(): Result<List<Stop>> =
        dataSource.getAllStops()

    suspend fun getStopById(id: Long): Result<Stop> =
        dataSource.getStopById(id)

    suspend fun getRoutsByStopId(id: Long): Result<StopWithRouts> =
        dataSource.getRoutsByStopId(id)
}
