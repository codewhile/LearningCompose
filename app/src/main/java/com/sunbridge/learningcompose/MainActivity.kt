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
import androidx.compose.ui.graphics.painter.Painter
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

            // Aplicando tema do material design nos componentes
            // O Material Design é baseado em trê características: Cor, Tipografia e forma
            LearningComposeTheme {

                // Serve para definir um rótulo de texto na tela
                //MessageCard(Message("Marcus Vinicius", "Oi"))

                Conversation(MessageRepository.conversationSample)

            }

        }

    }
}

data class Message(val author:String, val message:String)

@Composable
fun Conversation(messages:List<Message>) {

    LazyColumn {
        items(messages) { message ->
            MessageCard(message)
        }
    }
}


@Composable // Funções que são compostas recebem essa anotação
fun MessageCard(msg: Message) {

    // Row serve para organizar horizontalmente um elemento.
    // Moddificadores podem ser usados para decorar ou configurar um elemento(Tornar ele clicável)
    Row(modifier = Modifier.padding(all = 8.dp)) {

        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background),
            contentDescription = "Contact profile picture",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )

        // Serve como uma caixa em branco que pode dar espaço entre as coisas.
        Spacer(modifier = Modifier.width(8.dp))

        //  Serve para fazer um processo conhecido como recomposição.
        //  Os elementos que possuem o estado e os filhos deles serão redesenhados.
        var isExpanded by remember() {
            mutableStateOf(false)
        }

        // A função columm informa o compilador para organizar os elementos verticalmente.
        Column(modifier = Modifier.clickable { isExpanded = !isExpanded }) {
            Text(msg.author, color = MaterialTheme.colors.secondaryVariant, style = MaterialTheme.typography.subtitle2)
            Spacer(modifier = Modifier.height(4.dp))

            // Surface é uma caixa que vai dar uma destacada no que estiver dento dela
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(
                    msg.message,
                    style = MaterialTheme.typography.body2,
                    modifier = Modifier.padding(all = 4.dp),
                    maxLines = if (isExpanded) Int.MAX_VALUE else 1
                )
            }

        }

    }


}

@Preview(name = "Sample Conversation")
@Composable
fun PreviewConversation() {
    Conversation(messages = MessageRepository.conversationSample)
}

/* Serve para visualizar na própria IDE o Layout das funções compostas, mas você só pode usar parâmetros que recebem valores padrão ou sem parâmetros.
* Dessa forma, mesmo essa função não sendo chamada em lugar algum, o android studio cria uma janela de visualização que nos visualizar os elementos*/
@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode",
    showBackground = true,
)
@Composable
fun previewMessageCard() {
    MessageCard(Message("Vinicius", "Take a look at Jetpack Compose, it's great"))
}

