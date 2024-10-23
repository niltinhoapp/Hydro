package com.hydro.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "water_goals")
data class WaterGoal(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val goal: Int, // quantidade de água a ser consumida em mL
    val startDate: Date, // data de início da meta
    val endDate: Date, // data de fim da meta
    val achieved: Boolean = false // se a meta foi alcançada
) {
    override fun toString(): String {
        return "Meta de Água: $goal mL ($startDate - $endDate)"
    }
}

// Companion object para criar uma instância padrão
companion object {
    fun defaultWaterGoal(): WaterGoal {
        return WaterGoal(
            id = 0,
            goal = 2000, // 2 litros
            startDate = Date(),
            endDate = Date(),
            achieved = false
        )
    }
}

