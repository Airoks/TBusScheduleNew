package com.airoks.tbusschedulenew.data.repository.schedule

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Schedule
import com.airoks.tbusschedulenew.domain.entity.ScheduleWithDepartureTime

class ScheduleRepository(
    private val dataSource: ScheduleDataSource
) {
    suspend fun saveSchedules(schedules: List<Schedule>) =
        dataSource.saveSchedules(schedules)

    suspend fun getDepartureTimeByScheduleId(id: Long): Result<ScheduleWithDepartureTime> =
        dataSource.getDepartureTimeByScheduleId(id)
}
