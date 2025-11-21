package com.derkpy.note_ia.ui.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.derkpy.note_ia.R
import com.derkpy.note_ia.ui.theme.black
import com.derkpy.note_ia.ui.theme.border1
import com.derkpy.note_ia.ui.theme.primaryTwoDark
import com.derkpy.note_ia.ui.theme.tertiaryOneDark
import com.derkpy.note_ia.ui.theme.white

@Preview
@Composable
fun PresentationScreen(
    navigateToLogin: () -> Unit = {},
    navigateToSignUp: () -> Unit = {}){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Brush.verticalGradient(listOf(primaryTwoDark, black),
                startY = 0f,
                endY = 650f)
            ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.weight(1f))
        Image(painter = painterResource(
            id = R.drawable.logo_noteia),
            contentDescription = "",
            modifier = Modifier.scale(0.65f)
        )
        Spacer(modifier = Modifier.weight(1f))


        Text("La IA hasta tus notas",
            color = white,
            fontSize = 35.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.weight(1f))
        Button(onClick = {
            navigateToSignUp()
        },
            modifier = Modifier
                .fillMaxWidth()
                .height(45.dp)
                .padding(horizontal = 40.dp),
            colors = ButtonDefaults.buttonColors(containerColor = tertiaryOneDark)) {
            Text("Sing up free",
                color = black,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(modifier = Modifier.height(15.dp))
        CustomButton(painter = painterResource(id= R.drawable.logo_facebook), "Facebook")
        Spacer(modifier = Modifier.height(15.dp))
        CustomButton(painter = painterResource(id=R.drawable.logo_google), "Google")
        Text("Log in",
            color = white,
            modifier = Modifier.padding(20.dp)
                .clickable{navigateToLogin()},
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.weight(1f))

    }

}

@Composable
fun CustomButton(painter : Painter, text : String){

    Box(modifier = Modifier
        .fillMaxWidth()
        .height(45.dp)
        .padding(horizontal = 40.dp)
        .border(2.dp, border1, CircleShape),
        Alignment.CenterStart
    ) {
        Image(painter = painter,
            contentDescription = "",
            modifier = Modifier
                .padding(start = 15.dp)
                .size(25.dp)
                .clip(CircleShape)

        )
        Text(text,
        color = white,
        modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
        )
    }
}

