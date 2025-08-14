package com.willag.assistbot.view.auth.register

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.willag.assistbot.R
import com.willag.assistbot.ui.theme.AssistBotTheme
import com.willag.assistbot.ui.theme.Dimens
import com.willag.assistbot.view.core.components.AssistBotButton
import com.willag.assistbot.view.core.components.AssistBotText
import com.willag.assistbot.view.core.components.AssistBotTextField

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun RegisterScreenPreview() {
    AssistBotTheme {
        RegisterScreen(onNavigateToLogin = {})
    }
}

@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = hiltViewModel(), onNavigateToLogin: () -> Unit) {
    Scaffold { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize(),
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.weight(0.50f))
            AssistBotText(
                text = stringResource(R.string.signup_screen_header_title),
                modifier = Modifier
                    .padding(end = Dimens.paddingMedium),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
            AssistBotText(
                text = stringResource(R.string.signup_screen_header_description),
                modifier = Modifier
                    .padding(end = Dimens.paddingMedium),
                style = MaterialTheme.typography.bodyLarge
            )
            Spacer(modifier = Modifier.weight(0.05f))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = Dimens.paddingLarge),
                shape = MaterialTheme.shapes.medium
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(Dimens.paddingLarge),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    AssistBotTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = { },
                        labelText = stringResource(R.string.signup_screen_textfield_name),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
                    AssistBotTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = { },
                        labelText = stringResource(R.string.signup_screen_textfield_email),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
                    )
                    Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
                    AssistBotTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = { },
                        labelText = stringResource(R.string.signup_screen_textfield_password),
                        trailingIcon = {
                            /*IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            Icon(
                                imageVector = if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = if (passwordHidden) stringResource(R.string.login_screen_content_description_password_show) else stringResource(
                                    R.string.login_screen_content_description_password_hide
                                ),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }*/
                        },
                        //visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                    Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
                    AssistBotTextField(
                        modifier = Modifier.fillMaxWidth(),
                        value = "",
                        onValueChange = { },
                        labelText = stringResource(R.string.signup_screen_textfield_confirm_password),
                        trailingIcon = {
                            /*IconButton(onClick = { passwordHidden = !passwordHidden }) {
                            Icon(
                                imageVector = if (passwordHidden) Icons.Filled.Visibility else Icons.Filled.VisibilityOff,
                                contentDescription = if (passwordHidden) stringResource(R.string.login_screen_content_description_password_show) else stringResource(
                                    R.string.login_screen_content_description_password_hide
                                ),
                                tint = MaterialTheme.colorScheme.primary
                            )
                        }*/
                        },
                        //visualTransformation = if (passwordHidden) PasswordVisualTransformation() else VisualTransformation.None,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
                    )
                    Spacer(modifier = Modifier.padding(Dimens.paddingLarge))
                    AssistBotButton(
                        modifier = Modifier.fillMaxWidth(),
                        onClick = { /* TODO: Handle login action */ },
                        enabled = false,
                        text = stringResource(R.string.signup_screen_button_signup)
                    )
                    Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
                }
            }
            Spacer(modifier = Modifier.padding(Dimens.paddingMedium))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                AssistBotText(
                    text = stringResource(R.string.signup_screen_text_already_have_account),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                    modifier = Modifier.padding(end = Dimens.paddingSmall)
                )
                AssistBotText(
                    text = stringResource(R.string.signup_screen_text_login),
                    color = MaterialTheme.colorScheme.primary,
                    style = TextStyle(
                        fontSize = MaterialTheme.typography.bodyMedium.fontSize,
                        fontWeight = FontWeight.Bold
                    ),
                    modifier = Modifier.clickable { onNavigateToLogin() }
                )
            }
            Spacer(modifier = Modifier.weight(0.65f))
        }
    }
}