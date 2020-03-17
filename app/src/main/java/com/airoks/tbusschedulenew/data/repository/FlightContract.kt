package com.airoks.tbusschedulenew.data.repository

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Flight
import com.airoks.tbusschedulenew.domain.entity.FlightWithDirections

interface FlightContract {

    interface DataSource {
        suspend fun saveFlights(flights: List<Flight>)
        suspend fun getDirectionByFlightId(id: Long): Result<FlightWithDirections>
        suspend fun getFlightByType(type: Int): Result<List<Flight>>
    }

    interface Repository {
        suspend fun saveFlights(flights: List<Flight>)
        suspend fun getDirectionByFlightId(id: Long): Result<FlightWithDirections>
        suspend fun getFlightByType(type: Int): Result<List<Flight>>
    }
}
