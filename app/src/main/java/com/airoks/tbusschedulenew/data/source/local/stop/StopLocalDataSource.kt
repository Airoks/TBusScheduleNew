package com.airoks.tbusschedulenew.data.source.local.stop

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.data.repository.StopDataSource
import com.airoks.tbusschedulenew.domain.entity.Stop
import com.airoks.tbusschedulenew.domain.entity.StopWithRouts
import com.airoks.tbusschedulenew.presentation.CoroutineContextProvider
import kotlinx.coroutines.withContext

class StopLocalDataSource(
    private val stopDao: StopDao,
    private val contextProvider: CoroutineContextProvider
) : StopDataSource {

    override suspend fun saveStops(stops: List<Stop>) = withContext(contextProvider.IO) {
        stopDao.insert(stops)
    }

    override suspend fun getAllStops(): Result<List<Stop>> = withContext(contextProvider.IO) {
        try {
            return@withContext Result.Success(stopDao.getAllStops())
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getStopById(id: Long): Result<Stop> = withContext(contextProvider.IO) {
        try {
            val result = stopDao.getStopById(id)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The stop not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getRoutsByStopId(
        id: Long
    ): Result<StopWithRouts> = withContext(contextProvider.IO) {
        try {
            val result = stopDao.getRoutByStopId(id)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The routs with this id($id) not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }
}
