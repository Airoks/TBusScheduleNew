package com.airoks.tbusschedulenew.data.repository.departuretime

import com.airoks.tbusschedulenew.domain.entity.DepartureTime

class DepartureTimeRepository(
    private val dataSource: DepartureTimeDataSource
) {
    suspend fun save(departureTime: List<DepartureTime>) =
        dataSource.saveDepartureTime(departureTime)
}
