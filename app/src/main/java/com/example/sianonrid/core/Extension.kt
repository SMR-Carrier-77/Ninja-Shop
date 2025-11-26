package com.example.sianonrid.core

import android.content.pm.PackageManager
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat


fun EditText.extract(): String{
    return text.toString().trim()
}

fun requestPermission(
    request: ActivityResultLauncher<Array<String>>,
    permissions: Array<String>
) {
    request.launch(permissions)
}



fun areAPermissionGranted( permissions: Array<String>): Boolean{

    return permissions.all {

        ContextCompat.checkSelfPermission(RequireContext(),it)== PackageManager.PERMISSION_GRANTED
    }
}