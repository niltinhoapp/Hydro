package com.hydro.presentation

import android.os.Bundle
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModelProvider
import com.hydro.domain.WaterConsumption
import com.hydro.presentation.viewmodel.WaterConsumptionViewModel

// Tela de consumo de água
@Composable
fun WaterConsumptionScreen(
    viewModel: WaterConsumptionViewModel = viewModel(),
    navigationController: NavController
) {
    // Estado para armazenar o consumo de água
    var waterConsumption by remember { mutableStateOf(WaterConsumption.defaultWaterConsumption()) }

    // Tela de consumo de água
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Consumo de Água") },
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
            // Campo para inserir o consumo de água
            OutlinedTextField(
                value = waterConsumption.amount.toString(),
                onValueChange = { viewModel.updateAmount(it.toInt()) },
                label = { Text("Consumo de Água (mL)") }
            )

            // Botão para salvar o consumo de água
            Button(onClick = { viewModel.saveWaterConsumption() }) {
                Text("Salvar")
            }

            // Lista de consumos de água
            WaterConsumptionList(waterConsumptions = viewModel.waterConsumptions)
        }
    }
}

// Lista de consumos de água
@Composable
fun WaterConsumptionList(waterConsumptions: List<WaterConsumption>) {
    // Lista de consumos de água
    LazyColumn {
        items(waterConsumptions) { waterConsumption ->
            // Item da lista
            WaterConsumptionItem(waterConsumption = waterConsumption)
        }
    }
}

// Item da lista de consumos de água
@Composable
fun WaterConsumptionItem(waterConsumption: WaterConsumption) {
    // Linha do item
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Data do consumo
        Text("Data: ${waterConsumption.date}")

        // Quantidade do consumo
        Text("Quantidade: ${waterConsumption.amount} mL")
    }
}


//Essa classe representa a tela de consumo de água.

//Gostaria de:

//1. Implementar uma lógica de negócios.
//2. Usar essa classe em uma atividade.
//3. Adicionar validações para os métodos.
//4. Criar testes unitários.