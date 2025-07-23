package com.willag.assistbot.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import com.willag.assistbot.R
import com.willag.assistbot.ui.components.TextFieldCustom
import com.willag.assistbot.ui.theme.AssistBotTheme
import com.willag.assistbot.ui.theme.Dimens

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreenPreview() {
    AssistBotTheme {
        LoginScreen()
    }
}

@Composable
fun LoginScreen() {
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var passwordHidden by rememberSaveable { mutableStateOf(true) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        HeaderLogin(modifier = Modifier.weight(0.35f))
        LoginForm(
            modifier = Modifier.weight(0.65f),
            email = email,
            onEmailChange = { email = it },
            password = password,
            onPasswordChange = { password = it },
            passwordHidden = passwordHidden,
            onPasswordHiddenChange = { passwordHidden = it }
        )
    }
}

@Composable
fun HeaderLogin(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.Start
    ) {
        Text(
            text = stringResource(R.string.welcome_message),
            style = MaterialTheme.typography.titleLarge,
            modifier = Modifier.padding(Dimens.paddingLarge)
        )
        Text(
            text = stringResource(R.string.description),
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = Dimens.paddingLarge, end = Dimens.paddingLarge)
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
    passwordHidden: Boolean,
    onPasswordHiddenChange: (Boolean) -> Unit
) {
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
            ),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = modifier.padding(Dimens.paddingExtraLarge),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.signin_title),
                Modifier
                    .align(Alignment.Start)
                    .padding(start = Dimens.paddingMedium),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
            TextFieldCustom(
                value = email,
                onValueChange = onEmailChange,
                placeholder = stringResource(R.string.email_placeholder),
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon"
                    )
                },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
            TextFieldCustom(
                value = password,
                onValueChange = onPasswordChange,
                placeholder = stringResource(R.string.password_placeholder),
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon"
                    )
                },
                trailingIcon = {
                    IconButton(onClick = { onPasswordHiddenChange(!passwordHidden) }) {
                        Icon(
                            imageVector = if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                            contentDescription = if (passwordHidden) "Mostrar" else "Ocultar"
                        )
                    }
                },
                visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )
            Text(
                text = stringResource(R.string.forgot_password),
                Modifier
                    .padding(top = Dimens.paddingMedium)
                    .align(Alignment.End),
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.primary,
                fontWeight = MaterialTheme.typography.titleLarge.fontWeight
            )
            Spacer(modifier = Modifier.padding(Dimens.paddingLarge))
            Button(onClick = { /*TODO*/ }, modifier = Modifier.fillMaxWidth()) {
                Text(text = stringResource(R.string.signin_title))
            }
            Spacer(modifier = Modifier.padding(Dimens.paddingLarge))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = stringResource(R.string.dont_have_account),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(end = Dimens.paddingSmall)
                )
                Text(
                    text = stringResource(R.string.signup),
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = MaterialTheme.typography.titleLarge.fontWeight
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Text(text = "AssistBot © 2025", modifier = Modifier.padding(Dimens.paddingMedium))
        }
    }
}