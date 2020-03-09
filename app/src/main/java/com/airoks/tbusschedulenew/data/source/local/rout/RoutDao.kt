package com.airoks.tbusschedulenew.data.source.local.rout

import androidx.room.Dao
import androidx.room.Query
import com.airoks.tbusschedulenew.data.source.local.BaseDao
import com.airoks.tbusschedulenew.domain.entity.Rout
import com.airoks.tbusschedulenew.domain.entity.RoutsWithSchedule

@Dao
interface RoutDao : BaseDao<Rout> {

    @Query("SELECT * FROM Rout")
    suspend fun getAllRouts(): List<Rout>

    @Query("SELECT * FROM Rout WHERE stopId = :stopId AND directionId = :directionId")
    suspend fun getRoutByStopAndDirectionId(stopId: Long, directionId: Long): Rout?

    @Query("SELECT id FROM Rout WHERE stopId = :stopId AND directionId = :directionId")
    suspend fun getRoutIdByStopAndDirectionId(stopId: Long, directionId: Long): Long?

    @Query("SELECT * FROM Rout WHERE id = :id")
    suspend fun getScheduleByRoutId(id: Long): RoutsWithSchedule?
}
