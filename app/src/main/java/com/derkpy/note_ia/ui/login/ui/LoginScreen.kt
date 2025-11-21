package com.derkpy.note_ia.ui.login.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.derkpy.note_ia.R
import com.derkpy.note_ia.ui.login.vm.LoginViewModel
import com.derkpy.note_ia.ui.theme.black
import com.derkpy.note_ia.ui.theme.primaryTwoDark
import com.derkpy.note_ia.ui.theme.secondaryOneDark
import com.derkpy.note_ia.ui.theme.selectedField
import com.derkpy.note_ia.ui.theme.tertiaryOneDark
import com.derkpy.note_ia.ui.theme.unselectedField
import com.derkpy.note_ia.ui.theme.white
import kotlinx.coroutines.launch
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun LoginScreen(viewModel: LoginViewModel = koinViewModel()) {

    Login(viewModel)

}


@Composable
fun Login(viewModel: LoginViewModel) {

    val email: String by viewModel.email.collectAsStateWithLifecycle()
    val password: String by viewModel.password.collectAsStateWithLifecycle()
    val loginEnable: Boolean by viewModel.loginEnable.collectAsStateWithLifecycle()
    //val isLoading: Boolean by viewModel.isLoading.collectAsStateWithLifecycle()
    val corutineScope = rememberCoroutineScope()

    //if(isLoading) {
    //    Box(Modifier.fillMaxSize()) {
    //        CircularProgressInd
    //
    //
    //        icator(Modifier.align(Alignment.Center))
    //    }
    //} else {
    //}
        Column(modifier = Modifier
            .fillMaxSize()
            .background(primaryTwoDark)
            .padding(horizontal = 20.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {

            Row {
                Icon(
                    painter = painterResource(R.drawable.ic_back_24),
                    contentDescription = "",
                    tint = white,
                    modifier = Modifier.padding(top = 25.dp)
                )
                Spacer(modifier = Modifier.weight(1f))
            }

            Image(
                modifier = Modifier.scale(scaleX = 0.5f, scaleY = 0.5f),
                painter = painterResource(R.drawable.logo_noteia),
                contentDescription = "Logo"
            )

            Text(
                text = "User o Email",
                color = secondaryOneDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextFieldEmail(email) { viewModel.onLoginChanged(it, password) }

            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Password",
                color = secondaryOneDark
            )

            Spacer(modifier = Modifier.height(12.dp))

            TextFieldPassword(password) { viewModel.onLoginChanged(email, it) }

            Spacer(modifier = Modifier.height(16.dp))

            Button(loginEnable) {
                corutineScope.launch {
                    viewModel.onLoginSelected(
                        email,
                        password
                    )
                }
            }
            Spacer(modifier = Modifier.weight(1f))

    }
}

@Composable
fun Button(loginEnable: Boolean, onLoginSelected: () -> Unit){

    Button(onClick = {
        onLoginSelected()
    },
        modifier = Modifier
            .fillMaxWidth()
            .height(45.dp)
            .padding(horizontal = 55.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = tertiaryOneDark,
            disabledContainerColor = tertiaryOneDark.copy(alpha = 0.5f)
        ),
        enabled = loginEnable
    ) {
        Text("Log in",
            color = black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun TextFieldEmail(email: String, onTextChanged: (String) -> Unit){

    TextField(
        modifier = Modifier.fillMaxWidth()
            .clip(shape = CircleShape),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = unselectedField,
            focusedContainerColor = selectedField
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        value = email,
        onValueChange = { onTextChanged(it) },
    )
}

@Composable
fun TextFieldPassword(password: String, onTextChanged: (String) -> Unit){

    TextField(modifier = Modifier.fillMaxWidth()
        .clip(shape = CircleShape),
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = unselectedField,
            focusedContainerColor = selectedField),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        value = password,
        onValueChange = { onTextChanged(it) }
    )
}