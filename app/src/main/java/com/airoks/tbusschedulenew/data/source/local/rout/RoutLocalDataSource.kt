package com.airoks.tbusschedulenew.data.source.local.rout

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.data.repository.RoutContract
import com.airoks.tbusschedulenew.domain.entity.Rout
import com.airoks.tbusschedulenew.domain.entity.RoutsWithSchedule
import com.airoks.tbusschedulenew.presentation.CoroutineContextProvider
import kotlinx.coroutines.withContext

class RoutLocalDataSource(
    private val routDao: RoutDao,
    private val contextProvider: CoroutineContextProvider
) : RoutContract.DataSource {

    override suspend fun saveRouts(routs: List<Rout>) = withContext(contextProvider.IO) {
        routDao.insert(routs)
    }

    override suspend fun getAllRouts(): Result<List<Rout>> = withContext(contextProvider.IO) {
        try {
            return@withContext Result.Success(routDao.getAllRouts())
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getRoutByStopAndDirectionId(
        stopId: Long,
        directionId: Long
    ): Result<Rout> = withContext(contextProvider.IO) {
        try {
            val result = routDao.getRoutByStopAndDirectionId(stopId, directionId)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The routs not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getRoutIdByStopAndDirectionId(
        stopId: Long,
        directionId: Long
    ): Result<Long> = withContext(contextProvider.IO) {
        try {
            val result = routDao.getRoutIdByStopAndDirectionId(stopId, directionId)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The rout not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getScheduleByRoutId(
        id: Long
    ): Result<RoutsWithSchedule> = withContext(contextProvider.IO) {
        try {
            val result = routDao.getScheduleByRoutId(id)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The schedule not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }
}
