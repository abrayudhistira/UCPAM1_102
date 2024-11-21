package com.umy.ucp1_102

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SegmentedButtonDefaults.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.umy.ucp1_102.ui.theme.UCP1_102Theme
import androidx.compose.material.icons.Icons as Icons1


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            UCP1_102Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MAINKELAS(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MAINKELAS(modifier: Modifier = Modifier) {

    var email by remember { mutableStateOf("") }
    var notelpon by remember { mutableStateOf("") }
    var alamat by remember { mutableStateOf("") }
    var tahun by remember { mutableStateOf("") }

    var confemail by remember { mutableStateOf("") }
    var confnotelpon by remember { mutableStateOf("") }
    var confalamat by remember { mutableStateOf("") }
    var conftahun by remember { mutableStateOf("") }
    var dataTahun = listOf("2021", "2022", "2023")


    Column(
        modifier = Modifier
            .fillMaxWidth()
    )
    {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    Color.Magenta
                )
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Box(
                    contentAlignment = Alignment.BottomEnd
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.res),
                        contentDescription = "ini adalah icon",
                        modifier = Modifier.clip(CircleShape)
                    )
                    /*                Icon(
                    Icons1.Filled.CheckCircle,

                )*/
                }
                Column(
                    modifier = Modifier.padding(14.dp)
                ) {
                    Text(text = "Halo,")
                    Text(text = "Abra Yudhistira Racmadi")
                }
            }
        }
        Column(
            modifier = Modifier.fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Masukkan Biodata Kamu!")
            Text("Silahkan isi Data dengan Sebenar-Benarnya")
            TextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text("Email")
                },
                placeholder = {
                    Text("Isi Email Anda")
                },
                modifier = modifier.fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )
            TextField(
                value = notelpon,
                onValueChange = { notelpon = it },
                label = {
                    Text("Nomor Telpon")
                },
                placeholder = {
                    Text("Isi Email Anda")
                },
                modifier = modifier.fillMaxWidth()
                    .padding(5.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
            TextField(
                value = alamat,
                onValueChange = { alamat = it },
                label = {
                    Text("Alamat")
                },
                placeholder = {
                    Text("Isi Alamat Anda")
                },
                modifier = modifier.fillMaxWidth()
                    .padding(5.dp)
            )
            Row(
                modifier = Modifier.fillMaxWidth()
            ) {       //mengganti variabel modifier dengan Modifier
                dataTahun.forEach { selectedGender ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = tahun == selectedGender,
                            onClick = {
                                tahun = selectedGender
                            })
                    }
                    Text(text = selectedGender)
                }
            }
            Button(
                onClick = {
                    confemail = email
                    confalamat = alamat
                    confnotelpon = notelpon
                    conftahun = tahun
                }) {
                Text("Simpan")
            }
            TampilData(param = "email", argu = confemail)
            TampilData(param = "alamat", argu = confalamat)
            TampilData(param = "notelpon", argu = confnotelpon)
            TampilData(param = "gender", argu = conftahun)
        }
    }
}
@Composable
fun TampilData(param: String, argu: String) {
    Column (
        modifier = Modifier
            .fillMaxWidth()
            .background(Color.LightGray)
    ){
        Box (
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
        ){
            Column (
                modifier = Modifier.padding(16.dp)
            ) {
                Row (
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = param,
                        modifier = Modifier.weight(0.8f))
                    Text(text = ":",
                        modifier = Modifier.weight(0.2f))
                    Text(text = argu,
                        modifier = Modifier.weight(2f))

                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MAINKELAS()
}