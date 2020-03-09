package com.airoks.tbusschedulenew.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.airoks.tbusschedulenew.data.source.local.departuretime.DepartureTimeDao
import com.airoks.tbusschedulenew.data.source.local.stop.StopDao
import com.airoks.tbusschedulenew.data.source.local.direction.DirectionDao
import com.airoks.tbusschedulenew.data.source.local.flight.FlightDao
import com.airoks.tbusschedulenew.data.source.local.rout.RoutDao
import com.airoks.tbusschedulenew.data.source.local.schedule.ScheduleDao
import com.airoks.tbusschedulenew.domain.entity.*

@Database(entities = [Flight::class, Direction::class, Stop::class,
    Rout::class, Schedule::class, DepartureTime::class], version = 1, exportSchema = false)
abstract class BusScheduleDatabase : RoomDatabase() {

    abstract fun flightDao(): FlightDao
    abstract fun directionDao(): DirectionDao
    abstract fun stopDao(): StopDao
    abstract fun routDao(): RoutDao
    abstract fun scheduleDao(): ScheduleDao
    abstract fun departureTimeDao(): DepartureTimeDao
}
