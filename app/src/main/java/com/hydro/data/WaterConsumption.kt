package com.hydro.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "water_consumptions")
data class WaterConsumption(
    @PrimaryKey(autoGenerate = true) val id: Int,
    val amount: Int, // quantidade de água consumida em mL
    val date: Date, // data do consumo
    val goalId: Int, // ID da meta relacionada
    val syncStatus: SyncStatus = SyncStatus.PENDING // status de sincronização
) {
    override fun toString(): String {
        return "Consumo de Água: $amount mL em $date"
    }

    enum class SyncStatus {
        PENDING,
        SYNCED,
        FAILED
    }
}

// Companion object para criar uma instância padrão
companion object {
    fun defaultWaterConsumption(): WaterConsumption {
        return WaterConsumption(
            id = 0,
            amount = 0,
            date = Date(),
            goalId = 0,
            syncStatus = SyncStatus.PENDING
        )
    }
}


//Essa classe representa um consumo de água, com atributos para:

//- id: identificador único do consumo
//- amount: quantidade de água consumida em mL
//- date: data do consumo
//- goalId: ID da meta relacionada
//- syncStatus: status de sincronização

//O companion object fornece uma instância padrão da classe.

//Gostaria de:

//1. Adicionar validações para os atributos.
//2. Criar uma relação com outra entidade.
//3. Implementar uma lógica de negócios.
//4. Usar essa classe em uma atividade.