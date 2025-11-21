package com.derkpy.note_ia.ui.home.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.derkpy.note_ia.R
import com.derkpy.note_ia.ui.home.vm.HomeViewModel
import com.derkpy.note_ia.ui.theme.primaryTwoDark
import com.derkpy.note_ia.ui.theme.secondaryOneDark
import com.derkpy.note_ia.ui.theme.tertiaryTwoDark
import com.derkpy.note_ia.ui.theme.white
import org.koin.androidx.compose.koinViewModel

@Composable
fun HomeScreen(viewModel: HomeViewModel = koinViewModel()){

    HomeContent(viewModel)
}

@Composable
fun HomeContent(viewModel: HomeViewModel) {

    Column(modifier = Modifier
        .fillMaxSize()
        .background(secondaryOneDark),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Spacer(modifier = Modifier.weight(1f))


        Row {

            ButtonBackSession(viewModel)

            Spacer(modifier = Modifier.weight(1f))
        }

        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "Home Screen",
            color = primaryTwoDark,
            fontSize = 20.sp
        )

        Spacer(modifier = Modifier.weight(1f))

        ButtonAddTask()

        Spacer(modifier = Modifier.weight(1f))
    }
}

@Composable
fun ButtonAddTask(){

    Button(onClick = { /*TODO*/ },
            modifier = Modifier.fillMaxWidth()
                .height(40.dp)
                .padding(horizontal = 10.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = white)

        ) {

        Image(painter = painterResource(R.drawable.ic_bookmark_add_24),
            contentDescription = "Add Task"

        )
    }
}

@Composable
fun ButtonBackSession(viewModel: HomeViewModel) {



    Button(onClick = {

        viewModel.closeSession()

    }, modifier = Modifier.fillMaxWidth()
        .height(40.dp)
        .padding(horizontal = 20.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = tertiaryTwoDark
        )
        ) {

    }
}