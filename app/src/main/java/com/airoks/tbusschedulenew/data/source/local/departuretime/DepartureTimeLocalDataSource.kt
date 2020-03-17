package com.airoks.tbusschedulenew.data.source.local.departuretime

import com.airoks.tbusschedulenew.data.repository.DepartureTimeContract
import com.airoks.tbusschedulenew.domain.entity.DepartureTime
import com.airoks.tbusschedulenew.presentation.CoroutineContextProvider
import kotlinx.coroutines.withContext

class DepartureTimeLocalDataSource(
    private val departureTimeDao: DepartureTimeDao,
    private val contextProvider: CoroutineContextProvider
) : DepartureTimeContract.DataSource {

    override suspend fun saveDepartureTime(
        departureTime: List<DepartureTime>
    ) = withContext(contextProvider.IO) {
        departureTimeDao.insert(departureTime)
    }
}
