package com.airoks.tbusschedulenew.data.source.local.direction

import com.airoks.tbusschedulenew.data.Result
import com.airoks.tbusschedulenew.data.repository.DirectionContract
import com.airoks.tbusschedulenew.domain.entity.Direction
import com.airoks.tbusschedulenew.domain.entity.DirectionWithRouts
import com.airoks.tbusschedulenew.presentation.CoroutineContextProvider
import kotlinx.coroutines.withContext

class DirectionLocalDataSource(
    private val directionDao: DirectionDao,
    private val contextProvider: CoroutineContextProvider
) : DirectionContract.DataSource {

    override suspend fun saveDirections(directions: List<Direction>) = withContext(contextProvider.IO) {
        directionDao.insert(directions)
    }

    override suspend fun getDirectionById(
        id: Long
    ): Result<Direction> = withContext(contextProvider.IO) {
        try {
            val result = directionDao.getDirectionById(id)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The direction with this id($id) not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getFlightIdByDirectionId(
        id: Long
    ): Result<Long> = withContext(contextProvider.IO) {
        try {
            val result = directionDao.getFlightIdByDirectionId(id)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The flight id not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }

    override suspend fun getRoutByDirectionId(
        id: Long
    ): Result<DirectionWithRouts> = withContext(contextProvider.IO) {
        try {
            val result = directionDao.getRoutByDirectionId(id)
            if (result != null) {
                return@withContext Result.Success(result)
            } else {
                return@withContext Result.Error(Exception("The routs not found"))
            }
        } catch (e: Exception) {
            return@withContext Result.Error(e)
        }
    }
}
