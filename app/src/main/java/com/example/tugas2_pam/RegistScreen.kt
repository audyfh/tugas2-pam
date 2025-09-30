package com.example.tugas2_pam

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter
import com.example.tugas2_pam.ui.theme.Tugas2_PAMTheme

@Composable
fun RegistScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    onSaveClick: () -> Unit
) {

    var jabatanExpanded by remember { mutableStateOf(false) }
    var genderExpanded by remember { mutableStateOf(false) }
    val jabatanList = listOf("Mahasiswa", "Dosen", "Staff")
    val genderList = listOf("Laki-laki", "Perempuan")

    val imgPicker = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ){
        if (it != null){
            mainViewModel.imgUri = it
        }
    }


    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(
            modifier.height(22.dp)
        )
        Text(
            "Library Registration",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold
        )

        Spacer(modifier.height(24.dp))

        Image(
            painter = if (mainViewModel.imgUri != null) {
                rememberAsyncImagePainter(mainViewModel.imgUri)
            } else
                painterResource(R.drawable.img_add),
            contentDescription = "profile image",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .size(80.dp)
                .clickable {
                    imgPicker.launch("image/*")
                }
        )

        Column(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "Username",
                fontWeight = FontWeight.SemiBold
            )
            OutlinedTextField(
                value = mainViewModel.username,
                onValueChange = { mainViewModel.username = it },
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Column(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "Jabatan",
                fontWeight = FontWeight.SemiBold
            )
            Box {
                OutlinedTextField(
                    value = mainViewModel.jabatan,
                    onValueChange = {},
                    readOnly = true,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    trailingIcon = {
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = Modifier.clickable { jabatanExpanded = !jabatanExpanded }
                        )
                    }
                )

                DropdownMenu(
                    expanded = jabatanExpanded,
                    onDismissRequest = { jabatanExpanded = false },

                ) {
                    jabatanList.forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                jabatanExpanded = false
                                mainViewModel.jabatan = it
                            }
                        )
                    }
                }
            }
        }

        Column(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "Jenis Kelamin",
                fontWeight = FontWeight.SemiBold
            )
            Box {
                OutlinedTextField(
                    value = mainViewModel.jenisKelamin,
                    onValueChange = {},
                    modifier = modifier
                        .fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp),
                    trailingIcon = {
                        Icon(
                            Icons.Default.KeyboardArrowDown,
                            contentDescription = null,
                            modifier = modifier.clickable {
                                genderExpanded = !genderExpanded
                            }
                        )
                    },
                    readOnly = true
                )

                DropdownMenu(
                    expanded = genderExpanded,
                    onDismissRequest = { genderExpanded = false }
                ) {
                    genderList.forEach {
                        DropdownMenuItem(
                            text = { Text(it) },
                            onClick = {
                                genderExpanded = false
                                mainViewModel.jenisKelamin = it
                            }
                        )
                    }
                }
            }
        }

        Column(
            modifier = modifier
                .padding(top = 16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                "Email",
                fontWeight = FontWeight.SemiBold
            )
            OutlinedTextField(
                value = mainViewModel.email,
                onValueChange = { mainViewModel.email = it },
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
        }


        Spacer(modifier.weight(1f))
        OutlinedButton(
            onClick = { onSaveClick()},
            border = BorderStroke(0.dp,Color.Transparent),
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Black
            ),
            modifier = modifier
                .fillMaxWidth()
                .height(55.dp),
        ) {
            Text(
                "Save",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 18.sp
            )
        }
        Spacer(modifier.height(34.dp))


    }
}
