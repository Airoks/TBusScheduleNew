package com.airoks.tbusschedulenew.data.repository

import com.airoks.tbusschedulenew.domain.entity.DepartureTime

interface DepartureTimeDataSource {

    suspend fun saveDepartureTime(departureTime: List<DepartureTime>)
}
