package com.airoks.tbusschedulenew.data.repository.schedule

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Schedule
import com.airoks.tbusschedulenew.domain.entity.ScheduleWithDepartureTime

interface ScheduleDataSource {
    suspend fun saveSchedules(schedules: List<Schedule>)
    suspend fun getDepartureTimeByScheduleId(id: Long): Result<ScheduleWithDepartureTime>
}
