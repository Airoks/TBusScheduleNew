package com.airoks.tbusschedulenew.data.repository

import com.airoks.tbusschedulenew.domain.entity.DepartureTime

interface DepartureTimeContract {

    interface DataSource {
        suspend fun saveDepartureTime(departureTime: List<DepartureTime>)
    }

    interface Repository {

    }
}
