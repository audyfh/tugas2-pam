package com.example.tugas2_pam

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberAsyncImagePainter

@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier,
    mainViewModel: MainViewModel,
    onEditClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier.height(22.dp))
        Text(
            "Profile",
            fontSize = 24.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        )

        Spacer(modifier.height(24.dp))

        Image(
            painter = if (mainViewModel.imgUri != null) {
                rememberAsyncImagePainter(mainViewModel.imgUri)
            } else {
                painterResource(R.drawable.img_profile)
            },
            contentDescription = "profile image",
            contentScale = ContentScale.Fit,
            modifier = modifier
                .height(100.dp)
                .fillMaxWidth()
        )

        Spacer(modifier.height(24.dp))

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text("Username", fontWeight = FontWeight.SemiBold)
            OutlinedTextField(
                value = mainViewModel.username,
                onValueChange = {},
                readOnly = true,
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier.height(16.dp))

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text("Jabatan", fontWeight = FontWeight.SemiBold)
            OutlinedTextField(
                value = mainViewModel.jabatan,
                onValueChange = {},
                readOnly = true,
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier.height(16.dp))

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text("Jenis Kelamin", fontWeight = FontWeight.SemiBold)
            OutlinedTextField(
                value = mainViewModel.jenisKelamin,
                onValueChange = {},
                readOnly = true,
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier.height(16.dp))

        Column(
            modifier = modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            Text("Email", fontWeight = FontWeight.SemiBold)
            OutlinedTextField(
                value = mainViewModel.email,
                onValueChange = {},
                readOnly = true,
                modifier = modifier.fillMaxWidth(),
                shape = RoundedCornerShape(12.dp)
            )
        }

        Spacer(modifier.height(34.dp))

        OutlinedButton(
            onClick = { onEditClick() },
            colors = ButtonDefaults.outlinedButtonColors(
                containerColor = Color.Black
            ),
            modifier = modifier
                .fillMaxWidth()
                .height(55.dp),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                "Edit",
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontSize = 18.sp
            )
        }
    }
}
