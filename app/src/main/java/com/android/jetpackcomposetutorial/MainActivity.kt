package com.android.jetpackcomposetutorial

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.android.jetpackcomposetutorial.ui.theme.JetpackComposeTutorialTheme

private val messages: List<MyMessage> = listOf(
    MyMessage("Título 1", "Cuerpo del mensage 1"),
    MyMessage("Título 2", "Cuerpo del mensage 2"),
    MyMessage("Título 3", "Cuerpo del mensage 3"),
    MyMessage("Título 4", "Cuerpo del mensage 4"),
    MyMessage("Título 5", "Cuerpo del mensage 5"),
    MyMessage("Título 6", "Cuerpo del mensage 6"),
    MyMessage("Título 7", "Cuerpo del mensage 7"),
    MyMessage("Título 8", "Cuerpo del mensage 8"),
    MyMessage("Título 9", "Cuerpo del mensage 9"),
    MyMessage("Título 10", "Cuerpo del mensage 10"),
    MyMessage("Título 11", "Cuerpo del mensage 11"),
    MyMessage("Título 12", "Cuerpo del mensage 12"),
)


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackComposeTutorialTheme {
                MyMessages(messages)
            }

        }
    }
}

data class MyMessage (val title: String, val body: String)

@Composable
fun MyMessages(messages: List<MyMessage>) {
    LazyColumn{
        items(messages){message ->
            MyComponent(message)
        }
    }
}


@Composable
fun MyComponent(message: MyMessage) {
    Row(
        modifier = Modifier
            .background(MaterialTheme.colors.background)
            .padding(8.dp)
    ) {
        MyImage()
        MyTexts(message)
    }
}


@Composable
fun MyImage() {
    Image(
        painterResource(R.drawable.ic_launcher_foreground), "Imagen de fondo",
        Modifier
            .clip(CircleShape)
            .background(MaterialTheme.colors.primary)
            .size(64.dp)
    )
}

@Composable
fun MyTexts(message: MyMessage) {
    Column(modifier = Modifier.padding(start = 8.dp, top = 8.dp)) {
        MyText(text = message.title, MaterialTheme.colors.primary, MaterialTheme.typography.subtitle1)
        Spacer(modifier = Modifier.height(8.dp))
        MyText(
            text = message.body,
            MaterialTheme.colors.onBackground,
            MaterialTheme.typography.subtitle2
        )
    }


}

@Composable
fun MyText(text: String, color: Color, style: androidx.compose.ui.text.TextStyle) {
    Text(text, color = color, style = style)
}

@Preview(showSystemUi = true)
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES, showSystemUi = true)
@Composable
fun PreviewTexts() {
    JetpackComposeTutorialTheme {
/*
        val scrollState = rememberScrollState()

        Column(modifier = Modifier.verticalScroll(scrollState)){
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
            MyComponent()
       */
        MyMessages(messages)
    }

}
