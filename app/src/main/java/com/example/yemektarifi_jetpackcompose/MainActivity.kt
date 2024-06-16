package com.example.yemektarifi_jetpackcompose

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.yemektarifi_jetpackcompose.ui.theme.YemekTarifiJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            YemekTarifiJetpackComposeTheme {
                Surface {
                    Sayfa()
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun Sayfa() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Yazi(icerik = "Yemek Tarifi") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.anaRenk),
                    titleContentColor = colorResource(id = R.color.white),
                )
            )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.yemekresim),
                    contentDescription = "Yemek resim"
                )
                Row(
                    Modifier.fillMaxWidth(),
                    //Modifier.fillMaxWidth() bir Compose Modifier'dır ve bir Composable'ın genişliğini, ebeveyninin sağladığı maksimum genişliğe kadar doldurmasını sağlar. Bu, Composable'ın ebeveyni içindeki tüm yatay alanı kaplamasını sağlar.
                ) {
                    Button(
                        onClick = {
                            Log.e("Button", "Beğenildi")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.anaRenk)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Yazi(icerik = "Beğen")
                    }
                    Button(
                        onClick = {
                            Log.e("Button", "Yorum Yapıldı")
                        },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = colorResource(id = R.color.alternatifRenk)
                        ),
                        modifier = Modifier.weight(50f)
                    ) {
                        Yazi(icerik = "Yorum Yap")
                    }
                }
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(all = 10.dp),

                    ) {
                    Text(
                        text = "Köfte",
                        color = colorResource(id = R.color.alternatifRenk),
                        fontSize = 18.sp
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Yazi(icerik = "Izgaraya uygun")
                        Yazi(icerik = "7 Haziran")
                    }
                }
                Text(
                    text = "Köfte için öncelikle kıymayı bir kaba alın. Soğanı rendeleyin ve kıymanın üzerine ekleyin. Tuz, karabiber ve kimyonu ekleyip yoğurun. Ceviz büyüklüğünde parçalar koparıp yuvarlayın ve hafifçe bastırarak şekil verin. Tavada yağda kızartın.",
                    modifier = Modifier.padding(all = 25.dp)
                )
            }
        }
    )
}

@Composable
fun Yazi(icerik: String) {
    Text(text = icerik)
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    YemekTarifiJetpackComposeTheme {
        Sayfa()
    }
}