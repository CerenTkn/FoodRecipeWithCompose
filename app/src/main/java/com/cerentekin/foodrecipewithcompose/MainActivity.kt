package com.cerentekin.foodrecipewithcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposableTarget
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cerentekin.foodrecipewithcompose.ui.theme.FoodRecipeWithComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FoodRecipeWithComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Page()
                }
            }
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Page() {

    Scaffold (topBar = {
        TopAppBar(
            title = { Writing(content = "Food Recipe") },
            Modifier.background(color = Color(R.color.anaRenk)))

    },
        content = {
            Column (
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ){
                
                Image(

                    painter = painterResource(id = R.drawable.hamburger),
                    contentDescription = "",
                    modifier = Modifier.fillMaxHeight(0.35f)

                )

                Row(modifier = Modifier.fillMaxWidth()) {

                    Button(onClick = {
                        Log.e("button", "beğenildi") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.anaRenk)
                        ),
                        modifier = Modifier.weight(50f)
                        ) {
                        Writing(content = "Like")
                        
                    }

                    Button(onClick = {
                        Log.e("button", "yorum yapıldı") },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.alternatif)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Writing(content = "Comment")

                    }

                }
                Column(modifier = Modifier
                    .fillMaxWidth()
                    .padding(all = 10.dp)) {
                    Text(text = "Hamburger",
                        color = colorResource(id = R.color.alternatif),
                        fontSize = 18.sp)
                    Row (modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {

                        Writing(content = "fast food")
                        Writing(content = "27 November")
                    }
                }
                Text(text = "The best hamburger recipe is simple with just a few ingredients. These contain no breadcrumbs, allowing the flavor to come from the burger itself.\n" +
                        "Mix beef, grated onion, & Worcestershire sauce. Add salt & pepper to taste.\n" +
                        "Form patties & indent the center of each one with your thumb (this prevents the patties from swelling up in the center as they cook).\n" +
                        "Chill before cooking.", modifier = Modifier.padding(all = 10.dp),
                    textAlign = TextAlign.Center)
            }


        }
    )

}

@Composable
fun Writing(content :String) {
    Text(text = content)

}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    FoodRecipeWithComposeTheme {
        Page()
    }
}