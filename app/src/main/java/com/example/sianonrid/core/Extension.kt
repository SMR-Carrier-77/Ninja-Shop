package com.example.sianonrid.core

import androidx.fragment.app.Fragment
import android.content.pm.PackageManager
import android.widget.EditText
import androidx.activity.result.ActivityResultLauncher
import androidx.core.content.ContextCompat


fun EditText.extract(): String{
    return text.toString().trim()
}

fun Fragment.requestPermission(
    request: ActivityResultLauncher<Array<String>>,
    permissions: Array<String>
) {
    request.launch(permissions)
}

fun Fragment.allPermissionGranted(permissions: Array<String>): Boolean{

    return permissions.all {
        ContextCompat.checkSelfPermission( requireContext(),it) == PackageManager.PERMISSION_GRANTED
        }
}
