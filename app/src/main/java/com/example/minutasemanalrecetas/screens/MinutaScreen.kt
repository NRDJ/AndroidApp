package com.example.minutasemanalrecetas.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
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
        containerColor = Color.Transparent, // Make scaffold transparent to show background
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Text(
                            text = "Minuta Semanal",
                            style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                            color = MaterialTheme.colorScheme.primary
                        )
                        Text(
                            text = "¡Descubre recetas saludables!",
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        }
    ) { innerPadding ->
        // Gradient background
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(
                            MaterialTheme.colorScheme.primary.copy(alpha = 0.6f),
                            MaterialTheme.colorScheme.secondary
                        )
                    )
                )
                .padding(innerPadding)
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(8.dp)
            ) {
                items(listaRecetas) { receta ->
                    Card(
                        border = BorderStroke(2.dp, MaterialTheme.colorScheme.secondary),
                        shape = MaterialTheme.shapes.medium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.primaryContainer
                        )
                    ) {
                        Column(modifier = Modifier.padding(16.dp)) {
                            Text(
                                text = "${receta.dia} - ${receta.nombre}",
                                style = MaterialTheme.typography.titleMedium.copy(
                                    color = MaterialTheme.colorScheme.onPrimaryContainer,
                                    fontWeight = FontWeight.Bold
                                )
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = receta.descripcion,
                                style = MaterialTheme.typography.bodyMedium.copy(
                                    color = MaterialTheme.colorScheme.onPrimaryContainer
                                )
                            )
                            Spacer(modifier = Modifier.height(4.dp))
                            Text(
                                text = "Recomendaciones: ${receta.recomendaciones}",
                                style = MaterialTheme.typography.bodySmall.copy(
                                    fontStyle = FontStyle.Italic,
                                    color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.8f)
                                )
                            )
                        }
                    }
                }
            }
        }
    }
}