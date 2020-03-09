package com.airoks.tbusschedulenew.data.source.local.schedule

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.data.repository.ScheduleDataSource
import com.airoks.tbusschedulenew.domain.entity.Schedule
import com.airoks.tbusschedulenew.domain.entity.ScheduleWithDepartureTime
import com.airoks.tbusschedulenew.presentation.CoroutineContextProvider
import kotlinx.coroutines.withContext

class ScheduleLocalDataSource(
    private val scheduleDao: ScheduleDao,
    private val contextProvider: CoroutineContextProvider
) : ScheduleDataSource {

    override suspend fun saveSchedules(schedules: List<Schedule>) = withContext(contextProvider.IO) {
        scheduleDao.insert(schedules)
    }

    override suspend fun getDepartureTimeByScheduleId(
        id: Long
    ): Result<ScheduleWithDepartureTime> = withContext(contextProvider.IO) {
        try {
            val result = scheduleDao.getDepartureTimeByScheduleId(id)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The departure time not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }
}
