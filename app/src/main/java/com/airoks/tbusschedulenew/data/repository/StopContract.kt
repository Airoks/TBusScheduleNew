package com.airoks.tbusschedulenew.data.repository

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Stop
import com.airoks.tbusschedulenew.domain.entity.StopWithRouts

interface StopContract {

    interface DataSource {
        suspend fun saveStops(stops: List<Stop>)
        suspend fun getAllStops(): Result<List<Stop>>
        suspend fun getStopById(id: Long): Result<Stop>
        suspend fun getRoutsByStopId(id: Long): Result<StopWithRouts>
    }

    interface Repository {
        suspend fun saveStops(stops: List<Stop>)
        suspend fun getStops(page: Int, pageSize: Int)
        suspend fun getStopById(id: Long): Result<Stop>
        suspend fun getRoutsByStopId(id: Long, page: Int, pageSize: Int): Result<StopWithRouts>
    }
}
