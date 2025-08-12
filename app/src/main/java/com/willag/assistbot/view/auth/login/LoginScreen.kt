package com.willag.assistbot.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.willag.assistbot.R
import com.willag.assistbot.ui.theme.AssistBotTheme
import com.willag.assistbot.ui.theme.Dimens
import com.willag.assistbot.view.core.components.AssistBotButton
import com.willag.assistbot.view.core.components.AssistBotText
import com.willag.assistbot.view.core.components.AssistBotTextField

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    AssistBotTheme {
        LoginScreen() {}
    }
}

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    onNavigateToRegister: () -> Unit
) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            HeaderLogin(modifier = Modifier.weight(0.35f))
            LoginForm(
                modifier = Modifier.weight(0.65f),
                email = uiState.email,
                onEmailChange = { loginViewModel.onEmailChange(it) },
                password = uiState.password,
                onPasswordChange = { loginViewModel.onPasswordChange(it) },
                enabledButton = uiState.isLoginEnabled,
                onNavigateToRegister = onNavigateToRegister
            )
        }
    }
}

@Composable
fun HeaderLogin(modifier: Modifier) {
    Column(
        modifier = modifier
            .padding(Dimens.paddingLarge)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        AssistBotText(
            text = stringResource(R.string.login_screen_header_title),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(Modifier.padding(Dimens.paddingSmall))
        AssistBotText(
            text = stringResource(R.string.login_screen_header_description),
            style = MaterialTheme.typography.bodyLarge,
        )
    }
}

@Composable
fun LoginForm(
    modifier: Modifier,
    email: String,
    onEmailChange: (String) -> Unit,
    password: String,
    onPasswordChange: (String) -> Unit,
    enabledButton: Boolean,
    onNavigateToRegister: () -> Unit
) {
    var passwordHidden by rememberSaveable { mutableStateOf(true) }
    Box(
        modifier = modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(
                    topStart = Dimens.cornerRadiusExtraLarge,
                    topEnd = Dimens.cornerRadiusExtraLarge
                )
            )
            .background(
                MaterialTheme.colorScheme.surfaceDim
            )
    ) {
        Column(
            modifier = modifier.padding(Dimens.paddingExtraLarge),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AssistBotText(
                text = stringResource(R.string.login_screen_form_title),
                modifier = Modifier
                    .align(Alignment.Start)
                    .padding(start = Dimens.paddingMedium),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
            AssistBotTextField(
                modifier = Modifier.fillMaxWidth(),
                value = email,
                onValueChange = onEmailChange,
                labelText = stringResource(R.string.email_placeholder),
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
            AssistBotTextField(
                modifier = Modifier.fillMaxWidth(),
                value = password,
                onValueChange = onPasswordChange,
                labelText = stringResource(R.string.password_placeholder),
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { passwordHidden = !passwordHidden }) {
                        Icon(
                            imageVector = if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordHidden) "Mostrar" else "Ocultar"
                        )
                    }
                },
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            AssistBotText(
                text = stringResource(R.string.forgot_password),
                modifier = Modifier
                    .padding(top = Dimens.paddingMedium)
                    .align(Alignment.End),
                style = TextStyle(
                    fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.primary,
            )
            Spacer(modifier = Modifier.padding(Dimens.paddingLarge))
            AssistBotButton(
                modifier = Modifier.fillMaxWidth(),
                onClick = { /* TODO: Handle login action */ },
                enabled = enabledButton,
                text = stringResource(R.string.login_screen_form_title)
            )
            Spacer(modifier = Modifier.padding(Dimens.paddingLarge))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AssistBotText(
                    text = stringResource(R.string.dont_have_account),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(end = Dimens.paddingSmall)
                )
                AssistBotText(
                    text = stringResource(R.string.signup),
                    color = MaterialTheme.colorScheme.primary,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.clickable { onNavigateToRegister() }
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            AssistBotText(
                text = stringResource(R.string.login_screen_footer_text),
                modifier = Modifier.padding(Dimens.paddingMedium)
            )
        }
    }
}
