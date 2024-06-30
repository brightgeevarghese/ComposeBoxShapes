package edu.miu.composeboxshapes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import edu.miu.composeboxshapes.ui.theme.ComposeBoxShapesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeBoxShapesTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Column(
                        modifier = Modifier
                            .verticalScroll(rememberScrollState())
                    ) {
                        MyShape(
                            shape= RectangleShape,
                            text = "Rectangle",
                            Modifier.padding(innerPadding),
                            Color(0xFF005EB8)
                        )
                        MyShape(
                            shape= CircleShape,
                            text = "Circle",
                            Modifier.padding(innerPadding),
                            Color(0xFFFF9100)
                        )
                        MyShape(
                            shape = RoundedCornerShape(10.dp),
                            text = "RoundedCornerShape",
                            Modifier.padding(innerPadding),
                            Color(0xFF2A9723)
                        )
                        MyShape(
                            shape = CutCornerShape(20.dp),
                            text = "CutCornerShape",
                            Modifier.padding(innerPadding),
                            Color(0xFF29A1AF)
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun MyShape(shape: Shape, text: String, modifier: Modifier = Modifier, color: Color = Color.White) {
    Box(
        modifier = modifier
            .size(200.dp)
            .border(2.dp, color = Color.DarkGray, shape = shape)
            .clip(shape)
            .background(color),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            color = Color.White,
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBoxShapesTheme {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
        ) {
            MyShape(
                shape= RectangleShape,
                text = "Rectangle",
                modifier = Modifier.padding(bottom = 50.dp),
                color = Color(0xFF005EB8)
            )
            MyShape(
                shape= CircleShape,
                text = "Circle",
                modifier = Modifier.padding(bottom = 50.dp),
                color = Color(0xFFFF9100)
            )
            MyShape(
                shape = RoundedCornerShape(10.dp),
                text = "RoundedCornerShape",
                modifier = Modifier.padding(bottom = 50.dp),
                color = Color(0xFF2A9723)
            )
            MyShape(
                shape = CutCornerShape(20.dp),
                text = "CutCornerShape",
                modifier = Modifier.padding(bottom = 50.dp),
                color = Color(0xFF29A1AF)
            )
        }

    }
}
