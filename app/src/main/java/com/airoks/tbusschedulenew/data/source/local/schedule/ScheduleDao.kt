package com.airoks.tbusschedulenew.data.source.local.schedule

import androidx.room.Dao
import androidx.room.Query
import com.airoks.tbusschedulenew.data.source.local.BaseDao
import com.airoks.tbusschedulenew.domain.entity.Schedule
import com.airoks.tbusschedulenew.domain.entity.ScheduleWithDepartureTime

@Dao
interface ScheduleDao : BaseDao<Schedule> {

    @Query("SELECT * FROM Schedule WHERE id = :id")
    suspend fun getDepartureTimeByScheduleId(id: Long): ScheduleWithDepartureTime?
}
