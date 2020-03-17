package com.airoks.tbusschedulenew.data.repository

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.domain.entity.Schedule
import com.airoks.tbusschedulenew.domain.entity.ScheduleWithDepartureTime

interface ScheduleContract {

    interface DataSource {
        suspend fun saveSchedules(schedules: List<Schedule>)
        suspend fun getDepartureTimeByScheduleId(id: Long): Result<ScheduleWithDepartureTime>
    }

    interface Repository {

    }
}
