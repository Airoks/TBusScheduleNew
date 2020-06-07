package com.airoks.tbusschedulenew.data.repository.flight

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Flight
import com.airoks.tbusschedulenew.domain.entity.FlightWithDirections

class FlightRepository(
    private val dataSource: FlightDataSource
) {
    suspend fun saveFlights(flights: List<Flight>) =
        dataSource.saveFlights(flights)

    suspend fun getDirectionByFlightId(id: Long): Result<FlightWithDirections> =
        dataSource.getDirectionByFlightId(id)

    suspend fun getFlightByType(type: Int): Result<List<Flight>> =
        dataSource.getFlightByType(type)
}
