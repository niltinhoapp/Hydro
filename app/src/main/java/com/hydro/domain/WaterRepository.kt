
package com.hydro.domain

import com.hydro.data.WaterGoal
import com.hydro.data.WaterConsumption
import kotlinx.coroutines.flow.Flow

interface WaterRepository {
    suspend fun getWaterGoals(): List<WaterGoal>
    suspend fun getWaterGoal(id: Int): WaterGoal?
    suspend fun saveWaterGoal(waterGoal: WaterGoal)
    suspend fun deleteWaterGoal(id: Int)

    suspend fun getWaterConsumptions(): List<WaterConsumption>
    suspend fun getWaterConsumption(id: Int): WaterConsumption?
    suspend fun saveWaterConsumption(waterConsumption: WaterConsumption)
    suspend fun deleteWaterConsumption(id: Int)

    fun getWaterConsumptionsFlow(): Flow<List<WaterConsumption>>
    fun getWaterGoalFlow(id: Int): Flow<WaterGoal?>
}

class WaterRepositoryImpl(
    private val waterGoalDao: WaterGoalDao,
    private val waterConsumptionDao: WaterConsumptionDao
) : WaterRepository {

    override suspend fun getWaterGoals(): List<WaterGoal> {
        return waterGoalDao.getAll()
    }

    override suspend fun getWaterGoal(id: Int): WaterGoal? {
        return waterGoalDao.getById(id)
    }

    override suspend fun saveWaterGoal(waterGoal: WaterGoal) {
        waterGoalDao.insert(waterGoal)
    }

    override suspend fun deleteWaterGoal(id: Int) {
        waterGoalDao.delete(id)
    }

    override suspend fun getWaterConsumptions(): List<WaterConsumption> {
        return waterConsumptionDao.getAll()
    }

    override suspend fun getWaterConsumption(id: Int): WaterConsumption? {
        return waterConsumptionDao.getById(id)
    }

    override suspend fun saveWaterConsumption(waterConsumption: WaterConsumption) {
        waterConsumptionDao.insert(waterConsumption)
    }

    override suspend fun deleteWaterConsumption(id: Int) {
        waterConsumptionDao.delete(id)
    }

    override fun getWaterConsumptionsFlow(): Flow<List<WaterConsumption>> {
        return waterConsumptionDao.getAllFlow()
    }

    override fun getWaterGoalFlow(id: Int): Flow<WaterGoal?> {
        return waterGoalDao.getByIdFlow(id)
    }
}


//Essa classe representa um repositório para gerenciar dados de metas e consumos de água.

//Gostaria de:

//1. Implementar uma lógica de negócios.
//2. Usar essa classe em uma atividade.
//3. Adicionar validações para os métodos.
//4. Criar testes unitários.