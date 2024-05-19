package com.example.tinderfiap_challenge.uploadImg

import android.os.Bundle
//import androidx.activity.enableEdgeToEdge
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.view.ViewCompat
//import androidx.core.view.WindowInsetsCompat
//import com.example.tinderfiap_challenge.R

import android.content.Intent
import android.net.Uri
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import com.example.tinderfiap_challenge.uploadImg.UploadImgScreen

class UploadPhotoActivity : ComponentActivity() {

    private val selectImageLauncher = registerForActivityResult(ActivityResultContracts.GetContent()) { uri: Uri? ->
        uri?.let {
            // Faça algo com a URI da imagem selecionada, como exibir ou fazer upload
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
//            UploadPhotoScreenWrapper()
        }
    }

//    @Composable
//    fun UploadPhotoScreenWrapper() {
//        UploadImgScreen(onPhotoUpload = {
//            selectImageLauncher.launch("image/*")
//        })
//    }
}