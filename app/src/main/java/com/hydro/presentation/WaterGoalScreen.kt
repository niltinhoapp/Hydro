package com.hydro.presentation

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.hydro.domain.WaterGoal
import com.hydro.presentation.viewmodel.WaterGoalViewModel

// Tela de meta de água
@Composable
fun WaterGoalScreen(
    viewModel: WaterGoalViewModel = viewModel(),
    navigationController: NavController
) {
    // Estado para armazenar a meta de água
    var waterGoal by remember { mutableStateOf(WaterGoal.defaultWaterGoal()) }

    // Tela de meta de água
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Meta de Água") },
                navigationIcon = {
                    IconButton(onClick = { navigationController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, "Voltar")
                    }
                }
            )
        }
    ) { paddingValues ->
        // Contêiner para os componentes da tela
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Campo para inserir a meta de água
            OutlinedTextField(
                value = waterGoal.goal.toString(),
                onValueChange = { viewModel.updateGoal(it.toInt()) },
                label = { Text("Meta de Água (mL)") }
            )

            // Botão para salvar a meta de água
            Button(onClick = { viewModel.saveWaterGoal() }) {
                Text("Salvar")
            }

            // Lista de metas de água
            WaterGoalList(waterGoals = viewModel.waterGoals)
        }
    }
}

// Lista de metas de água
@Composable
fun WaterGoalList(waterGoals: List<WaterGoal>) {
    // Lista de metas de água
    LazyColumn {
        items(waterGoals) { waterGoal ->
            // Item da lista
            WaterGoalItem(waterGoal = waterGoal)
        }
    }
}

// Item da lista de metas de água
@Composable
fun WaterGoalItem(waterGoal: WaterGoal) {
    // Linha do item
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Data de início da meta
        Text("Data de Início: ${waterGoal.startDate}")

        // Data de fim da meta
        Text("Data de Fim: ${waterGoal.endDate}")

        // Quantidade da meta
        Text("Quantidade: ${waterGoal.goal} mL")
    }
}


//Essa classe representa a tela de meta de água.

//Gostaria de:

//1. Implementar uma lógica de negócios.
//2. Usar essa classe em uma atividade.
//3. Adicionar validações para os métodos.
//4. Criar testes unitários.