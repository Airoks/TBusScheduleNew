package com.airoks.tbusschedulenew.data.source.local.stop

import androidx.room.Dao
import androidx.room.Query
import com.airoks.tbusschedulenew.data.source.local.BaseDao
import com.airoks.tbusschedulenew.domain.entity.Stop
import com.airoks.tbusschedulenew.domain.entity.StopWithRouts

@Dao
interface StopDao : BaseDao<Stop> {

    @Query("SELECT * FROM Stop")
    suspend fun getAllStops(): List<Stop>

    @Query("SELECT * FROM Stop LIMIT :limit OFFSET :offset")
    suspend fun getStops(limit: Int, offset: Int): List<Stop>

    @Query("SELECT * FROM Stop WHERE id = :id")
    suspend fun getStopById(id: Long): Stop?

    @Query("SELECT * FROM Stop WHERE id = :id")
    suspend fun getRoutByStopId(id: Long): StopWithRouts?
}
