package com.example.sianonrid.Views.dasboard.seller.upload

import android.Manifest
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import com.example.sianonrid.R
import com.example.sianonrid.base.Basefragment
import com.example.sianonrid.core.extract
import com.example.sianonrid.core.requestPermission
import com.example.sianonrid.databinding.FragmentUploadProductBinding
import com.example.sianonrid.db.models.Product

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
            if ()
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


}