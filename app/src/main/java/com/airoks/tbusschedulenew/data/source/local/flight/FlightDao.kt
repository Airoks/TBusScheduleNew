package com.airoks.tbusschedulenew.data.source.local.flight

import androidx.room.Dao
import androidx.room.Query
import com.airoks.tbusschedulenew.data.source.local.BaseDao
import com.airoks.tbusschedulenew.domain.entity.Flight
import com.airoks.tbusschedulenew.domain.entity.FlightWithDirections

@Dao
interface FlightDao : BaseDao<Flight> {

    @Query("SELECT * FROM Flight WHERE id = :id")
    suspend fun getDirectionsByFlightId(id: Long): FlightWithDirections?

    @Query("SELECT * FROM Flight WHERE Flight.type_id = :type")
    suspend fun getFlightsByType(type: Int): List<Flight>?
}
