package com.airoks.tbusschedulenew.data.repository.stop

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Stop
import com.airoks.tbusschedulenew.domain.entity.StopWithRouts

interface StopDataSource {
    suspend fun saveStops(stops: List<Stop>)
    suspend fun getAllStops(): Result<List<Stop>>
    suspend fun getStopById(id: Long): Result<Stop>
    suspend fun getRoutsByStopId(id: Long): Result<StopWithRouts>
}
