package com.example.w2_androidstudygroup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.w2_androidstudygroup.ui.theme.MotionColor
import com.example.w2_androidstudygroup.ui.theme.parkinsansFamily
import com.example.w2_androidstudygroup.ui.theme.robotoFamily

@Composable
fun LoginScreen(navController: NavController? = null){
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var context = LocalContext.current

    Scaffold(
        content = {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Image(
                    painter = painterResource(R.drawable.background_image),
                    contentDescription = "Background Image",
                    contentScale = ContentScale.FillHeight,
                    modifier = Modifier.fillMaxSize()
                )

                Card(
                    modifier = Modifier
                        .wrapContentSize()
                        .clip(RoundedCornerShape(4.dp))
                        .padding(16.dp),
                    colors = CardDefaults.cardColors(containerColor = Color.White)
                ) {
                    Column(
                        modifier = Modifier
                            .padding(it)
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Spacer(modifier = Modifier.height(12.dp))

                        Image(
                            painter = painterResource(R.drawable.motion_logo),
                            contentDescription = "Motion logo"
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        Text(
                            text = "Login To Your Account",
                            fontFamily = parkinsansFamily,
                            fontWeight = FontWeight.Bold,
                            fontSize = 25.sp
                        )

                        Spacer(modifier = Modifier.height(16.dp))

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = username,
                            onValueChange = {
                                username = it
                            },
                            label = {
                                Text("Username")
                            }
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        OutlinedTextField(
                            modifier = Modifier.fillMaxWidth(),
                            value = password,
                            onValueChange = {
                                password = it
                            },
                            trailingIcon = {
                                val icon = if(passwordVisible) R.drawable.visibility_off else R.drawable.visibility
                                IconButton(
                                    onClick = {
                                        passwordVisible = !passwordVisible
                                    }
                                ) {
                                    Icon(
                                        painter = painterResource(icon),
                                        contentDescription = "Show Password"
                                    )
                                }
                            },
                            visualTransformation = if(passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                            label = {
                                Text("Password")
                            }
                        )

                        Spacer(modifier = Modifier.height(12.dp))

                        Button(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Akun dengan username = $username telah berhasil login",
                                    Toast.LENGTH_LONG
                                ).show()

                                navController?.navigate(HomeScreen)
                            },
                            colors = ButtonDefaults.buttonColors(Color.Red)
                        ) {
                            Text("Login", fontFamily = parkinsansFamily)
                        }

                        Spacer(modifier = Modifier.height(2.dp))

                        TextButton(
                            modifier = Modifier.fillMaxWidth(),
                            onClick = {
                                Toast.makeText(
                                    context,
                                    "Masuk ke register page",
                                    Toast.LENGTH_LONG
                                ).show()

                                navController?.navigate(RegisterScreen)
                            }
                        ) {
                            Text("Don't have account yet?", color = Color.Black)
                        }

                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewLoginScreen() {
    LoginScreen(navController = null)
}