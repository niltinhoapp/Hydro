package com.hydro.utils

// Utilitário para operações matemáticas
object MathUtils {

    // Constante para representar mililitros por litro
    private const val ML_PER_LITER = 1000.0

    // Conversão de mililitros para litros
    fun mlToLiters(ml: Double): Double {
        return ml / ML_PER_LITER
    }

    // Conversão de litros para mililitros
    fun litersToMl(liters: Double): Double {
        return liters * ML_PER_LITER
    }

    // Cálculo de porcentagem
    fun calculatePercentage(value: Double, total: Double): Double {
        return (value / total) * 100
    }

    // Arredondamento de valor para inteiro mais próximo
    fun roundToNearestInteger(value: Double): Int {
        return kotlin.math.round(value).toInt()
    }

    // Verificação se um valor está dentro de um intervalo
    fun isWithinRange(value: Double, min: Double, max: Double): Boolean {
        return value >= min && value <= max
    }
}


//Essa classe representa um utilitário para operações matemáticas.

