package com.airoks.tbusschedulenew.data.source.local.departuretime

import androidx.room.Dao
import com.airoks.tbusschedulenew.data.source.local.BaseDao
import com.airoks.tbusschedulenew.domain.entity.DepartureTime

@Dao
interface DepartureTimeDao : BaseDao<DepartureTime>
