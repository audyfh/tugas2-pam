package com.example.tugas2_pam

import android.net.Uri
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    var username by mutableStateOf("")
    var jabatan by mutableStateOf("")
    var jenisKelamin by mutableStateOf("")
    var email by mutableStateOf("")
    var imgUri by mutableStateOf<Uri?>(null)

}