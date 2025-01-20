package com.example.minutasemanalrecetas.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import com.example.minutasemanalrecetas.model.Receta

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MinutaScreen() {
    val listaRecetas = listOf(
        Receta(
            nombre = "Pollo al Horno con Verduras",
            descripcion = "Pollo marinado y horneado con zanahorias y papas.",
            recomendaciones = "Ideal para almuerzo, bajo en grasas saturadas.",
            dia = "Lunes"
        ),
        Receta(
            nombre = "Ensalada César con Pollo",
            descripcion = "Ensalada fresca con aderezo ligero y pollo a la plancha.",
            recomendaciones = "Rica en fibra y proteína.",
            dia = "Martes"
        ),
        Receta(
            nombre = "Pescado al Vapor con Arroz Integral",
            descripcion = "Filete de pescado al vapor con especias y arroz integral.",
            recomendaciones = "Buena fuente de omega-3 y fibra.",
            dia = "Miércoles"
        ),
        Receta(
            nombre = "Sopa de Verduras y Legumbres",
            descripcion = "Sopa nutritiva con vegetales y legumbres mixtas.",
            recomendaciones = "Alto contenido de vitaminas y proteínas vegetales.",
            dia = "Jueves"
        ),
        Receta(
            nombre = "Pasta Integral con Salsa de Tomate Natural",
            descripcion = "Pasta integral con salsa de tomate y especias.",
            recomendaciones = "Fuente de carbohidratos de absorción lenta.",
            dia = "Viernes"
        )
    )

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Minuta Semanal") })
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(8.dp)
        ) {
            items(listaRecetas) { receta ->
                Card(
                    border = BorderStroke(1.dp, Color.LightGray),
                    shape = MaterialTheme.shapes.medium,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "${receta.dia} - ${receta.nombre}",
                            style = MaterialTheme.typography.titleMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = receta.descripcion,
                            style = MaterialTheme.typography.bodyMedium
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Recomendaciones: ${receta.recomendaciones}",
                            style = MaterialTheme.typography.bodySmall,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }
        }
    }
}