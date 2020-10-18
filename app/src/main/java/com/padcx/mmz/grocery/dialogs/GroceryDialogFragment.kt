package com.padcx.mmz.grocery.dialogs

import android.app.Activity
import android.content.ContentResolver
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.padcx.mmz.grocery.R
import com.padcx.mmz.grocery.data.vos.GroceryVO
import com.padcx.mmz.grocery.mvp.presenters.MainPresenter
import com.padcx.mmz.grocery.mvp.presenters.impls.MainPresenterImpl
import kotlinx.android.synthetic.main.dialog_add_grocery.*
import kotlinx.android.synthetic.main.dialog_add_grocery.view.*
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException

class GroceryDialogFragment : DialogFragment() {

    companion object {
        const val TAG_ADD_GROCERY_DIALOG = "TAG_ADD_GROCERY_DIALOG"
        const val BUNDLE_NAME = "BUNDLE_NAME"
        const val BUNDLE_DESCRIPTION = "BUNDLE_DESCRIPTION"
        const val BUNDLE_AMOUNT = "BUNDLE_AMOUNT"
        const val BUNDLE_IMAGE = "BUNDLE_IMAGE"

        const val PICK_IMAGE_FROM_DIALOG = 1995

        fun newFragment(): GroceryDialogFragment {
            return GroceryDialogFragment()
        }
    }

    private lateinit var mPresenter: MainPresenter
    private var mBitMapImage: Bitmap? = null
    private val groceryVO = GroceryVO()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.dialog_add_grocery, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()

        view.etGroceryName?.setText(arguments?.getString(BUNDLE_NAME))
        view.etDescription?.setText(arguments?.getString(BUNDLE_DESCRIPTION))
        view.etAmount?.setText(arguments?.getString(BUNDLE_AMOUNT))

        Glide.with(this)
            .load(arguments?.getString(BUNDLE_IMAGE))
            .placeholder(R.drawable.ic_baseline_image_24)
            .into(ivFood)

        view.btnAddGrocery.setOnClickListener {
            /*mPresenter.onTapAddGrocery(
                etGroceryName.text.toString(),
                etDescription.text.toString(),
                etAmount.text.toString().toInt()
            )*/

            if(mBitMapImage!=null){
                groceryVO.name = etGroceryName.text.toString()
                groceryVO.description = etDescription.text.toString()
                groceryVO.amount = etAmount.text.toString().toInt()

                mBitMapImage?.let { bitmap ->
                    mPresenter.onTapAddGrocery(groceryVO, bitmap)
                }
                dismiss()

            }else{
                    mPresenter.onTapAddGroceryWithoutImage(
                        etGroceryName.text.toString(),
                        etDescription.text.toString(),
                        etAmount.text.toString().toInt(),
                        arguments?.getString(BUNDLE_IMAGE).toString()
                    )

                dismiss()
            }
        }

        /* view.btnUpload.setOnClickListener {
             mPresenter.onTapAddGrocery(
                 etGroceryName.text.toString(),
                 etDescription.text.toString(),
                 etAmount.text.toString().toInt()
             )
             dismiss()
         }*/

        view.ivFood.setOnClickListener {
            val intent = Intent()
            intent.type = "image/*"
            intent.action = Intent.ACTION_GET_CONTENT
            startActivityForResult(
                Intent.createChooser(intent, "Select Picture"),
                PICK_IMAGE_FROM_DIALOG
            )
        }
    }

    private fun setUpPresenter() {
        activity?.let {
            mPresenter = ViewModelProviders.of(it).get(MainPresenterImpl::class.java)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_FROM_DIALOG && resultCode == Activity.RESULT_OK) {
            if (data == null || data.data == null) {
                return
            }
            val filePath = data.data
            try {
                val file = File(filePath?.path!!)
                filePath?.let {
                    mBitMapImage =
                        activity?.contentResolver?.let { it1 -> getBitmap(it, file, it1) }
                }
                Glide.with(this)
                    .load(mBitMapImage)
                    .placeholder(R.drawable.ic_baseline_image_24)
                    .into(ivFood)

            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
    }


    private fun getBitmap(
        selectedPhotoUri: Uri,
        file: File,
        contentResolver: ContentResolver
    ): Bitmap? {
        try {
            selectedPhotoUri?.let {
                if (Build.VERSION.SDK_INT < 28) {
                    return MediaStore.Images.Media.getBitmap(
                        contentResolver,
                        selectedPhotoUri
                    )

                } else {
                    val source = ImageDecoder.createSource(file)
                    return ImageDecoder.decodeBitmap(source)

                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        }
    }
}