package com.airoks.tbusschedulenew.data.source.local.flight

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.data.repository.FlightContract
import com.airoks.tbusschedulenew.domain.entity.Flight
import com.airoks.tbusschedulenew.domain.entity.FlightWithDirections
import com.airoks.tbusschedulenew.presentation.CoroutineContextProvider
import kotlinx.coroutines.withContext

class FlightLocalDataSource(
    private val flightDao: FlightDao,
    private val contextProvider: CoroutineContextProvider
) : FlightContract.DataSource {

    override suspend fun saveFlights(flights: List<Flight>) = withContext(contextProvider.IO) {
        flightDao.insert(flights)
    }

    override suspend fun getDirectionByFlightId(
        id: Long
    ): Result<FlightWithDirections> = withContext(contextProvider.IO) {
        try {
            val result = flightDao.getDirectionsByFlightId(id)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("This flight has no directions"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getFlightByType(
        type: Int
    ): Result<List<Flight>> = withContext(contextProvider.IO) {
        try {
            val result = flightDao.getFlightsByType(type)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The flight this type not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

}
