package com.revature.implicitintentexample

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import com.revature.implicitintentexample.ui.theme.ImplicitIntentExampleTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ImplicitIntentExampleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    var context = LocalContext.current
                    test(context)
                }
            }
        }
    }
}
@Composable
fun test(context: Context){



    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Button(onClick = {

            val sendIntent = Intent().apply {

                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT,"Ryan")
                type = "text/plain"
            }
            context.startActivity(sendIntent)

        }) {

            Text("Send Text Message")

        }

        Spacer(Modifier.size(10.dp))

        Button(onClick = {

            val sendIntent = Intent().apply {

                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_EMAIL,"Ryan")
                type = "text/plain"
            }
            context.startActivity(sendIntent)
        }) {

            Text("Send Email")

        }
    }
}
