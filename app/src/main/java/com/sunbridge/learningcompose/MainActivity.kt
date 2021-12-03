package com.sunbridge.learningcompose

import android.content.res.Configuration
import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.Role.Companion.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.unit.dp
import com.sunbridge.learningcompose.ui.theme.LearningComposeTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Serve para definir o Layout da Activity
        setContent {

            // Serve para definir um rótulo de texto na tela
            MessageCard(name = "Android")

        }

    }
}


@Composable // Funções que são compostas recebem essa anotação
fun MessageCard(name: String) {
    Text("Hello $name")
}


/* Serve para visualizar na própria IDE o Layout das funções compostas, mas você só pode usar parâmetros que recebem valores padrão ou sem parâmetros.
* Dessa forma, mesmo essa função não sendo chamada em lugar algum, o android studio cria uma janela de visualização que nos visualizar os elementos*/
@Preview
@Composable
fun previewMessageCard() {
    MessageCard(name = "Android")
}

