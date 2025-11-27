package com.example.sianonrid.Views.dasboard.seller.upload

import android.Manifest
import android.app.Activity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.sianonrid.R
import com.example.sianonrid.base.Basefragment
import com.example.sianonrid.core.allPermissionGranted
import com.example.sianonrid.core.extract
import com.example.sianonrid.core.requestPermission
import com.example.sianonrid.databinding.FragmentUploadProductBinding
import com.example.sianonrid.db.models.Product
import com.github.dhaval2404.imagepicker.ImagePicker
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UploadProductFragment : Basefragment<FragmentUploadProductBinding>(
    FragmentUploadProductBinding::inflate
) {
    override fun setListener() {

        permissoinRequest=getpermissoinRequest()

         binding.apply {
             ivProduct.setOnClickListener {
                 requestPermission(permissoinRequest,permissoinList)
             }

             btnUploadProduct.setOnClickListener {
              val name=etProductName.extract()
                 val price=etProductPrice.extract()
                 val description=etProductDiscription.extract()
                 val amount=etProductAmount.extract()

                 val product= Product(
                     name=name,
                     description=description,
                     price=price.toDouble(),
                     amount = amount.toInt()
                 )
                 uploadproduct(product)
             }
         }
    }

    private fun uploadproduct(product: Product) {

    }

    private fun getpermissoinRequest():ActivityResultLauncher<Array<String>>{
        return registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
          if (allPermissionGranted(permissoinList)){
              Toast.makeText(requireContext(),"Ase", Toast.LENGTH_SHORT).show()

              ImagePicker.with(this)
                  .compress(1024)         //Final image size will be less than 1 MB(Optional)
                  .maxResultSize(512, 512)  //Final image resolution will be less than 1080 x 1080(Optional)
                  .createIntent { intent ->
                      startForProfileImageResult.launch(intent)
                  }

          }else{
              Toast.makeText(requireContext(),"nai", Toast.LENGTH_SHORT).show()
          }
        }
    }

    override fun allObserver() {

    }


    companion object{
        private val permissoinList=arrayOf(
            Manifest.permission.READ_EXTERNAL_STORAGE,
            Manifest.permission.CAMERA
        )
    }

    private lateinit var permissoinRequest: ActivityResultLauncher<Array<String>>

    private val startForProfileImageResult =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            val resultCode = result.resultCode
            val data = result.data

            if (resultCode == Activity.RESULT_OK) {
                //Image Uri will not be null for RESULT_OK
                val fileUri = data?.data!!
                Log.d("TAG", "$fileUri ")


            } else if (resultCode == ImagePicker.RESULT_ERROR) {
                Toast.makeText(requireContext(), ImagePicker.getError(data), Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(requireContext(), "Task Cancelled", Toast.LENGTH_SHORT).show()
            }
        }


}

