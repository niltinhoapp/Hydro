package com.hydro.domain

import com.hydro.data.WaterGoal
import com.hydro.data.WaterConsumption
import com.hydro.repository.WaterRepository

// Serviço para gerenciar metas e consumos de água
class WaterService(private val repository: WaterRepository) {

    // Salvar meta de água
    suspend fun saveWaterGoal(waterGoal: WaterGoal) {
        repository.saveWaterGoal(waterGoal)
    }

    // Obter metas de água
    suspend fun getWaterGoals(): List<WaterGoal> {
        return repository.getWaterGoals()
    }

    // Salvar consumo de água
    suspend fun saveWaterConsumption(waterConsumption: WaterConsumption) {
        repository.saveWaterConsumption(waterConsumption)
    }

    // Obter consumos de água
    suspend fun getWaterConsumptions(): List<WaterConsumption> {
        return repository.getWaterConsumptions()
    }

    // Verificar se a meta de água foi alcançada
    suspend fun isWaterGoalAchieved(waterGoal: WaterGoal): Boolean {
        val consumptions = repository.getWaterConsumptions()
        val totalConsumption = consumptions.sumOf { it.amount }
        return totalConsumption >= waterGoal.goal
    }

    // Calcular progresso da meta de água
    suspend fun calculateWaterGoalProgress(waterGoal: WaterGoal): Float {
        val consumptions = repository.getWaterConsumptions()
        val totalConsumption = consumptions.sumOf { it.amount }
        return (totalConsumption / waterGoal.goal) * 100
    }
}


//Essa classe representa um serviço para gerenciar metas e consumos de água.

//Gostaria de:

//1. Implementar uma lógica de negócios.
//2. Usar essa classe em uma atividade.
//3. Adicionar validações para os métodos.
//4. Criar testes unitários.