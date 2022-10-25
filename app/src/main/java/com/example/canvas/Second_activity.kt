package com.example.canvas

import android.app.ProgressDialog
import android.content.Context
import android.graphics.*
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.MediaStore
import android.text.Layout
import android.text.StaticLayout
import android.text.TextPaint
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.withTranslation
import com.google.firebase.storage.FileDownloadTask
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.IOException
import java.lang.System.out


class Second_activity : AppCompatActivity() {
    private var imageView: ImageView? = null
    private var storageReference: StorageReference? = null
    private var storageReference1: StorageReference? = null
    private var button: Button? = null
    private var progressDialog: ProgressDialog? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        imageView = findViewById(R.id.secondActivity)
        button = findViewById(R.id.storage)

        progressDialog = ProgressDialog(this@Second_activity)
        progressDialog!!.setTitle("Login")
        progressDialog!!.setMessage("Please Wait \n Validation in Progress")

        val intent = intent
        val str = intent.getStringExtra("message_key")
        val str2 = intent.getStringExtra("message_key1")
        val resources = this@Second_activity.resources
        val scale = resources.displayMetrics.density
        var bitmap2 = BitmapHelper.getInstance().bitmap
        var bitmapConfig = bitmap2.config
        if (bitmapConfig == null) {
            bitmapConfig = Bitmap.Config.ARGB_8888
        }
        bitmap2 = bitmap2.copy(bitmapConfig, true)
        val myDrawable = getResources().getDrawable(R.drawable.preto)
        //   Bitmap myLogo = ((BitmapDrawable) myDrawable).getBitmap();
        val canvas = Canvas(bitmap2)
        val textPaint2 = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint2.textAlign = Paint.Align.CENTER
        textPaint2.textSize = 225f
        textPaint2.typeface = ResourcesCompat.getFont(this, R.font.ralewaythin)
        textPaint2.color = Color.rgb(6, 94, 105)
        //     val xPos2 = canvas.width / 2
        //  val yPos2 = 1455
        val textPaint3 = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint3.textAlign = Paint.Align.CENTER
        textPaint3.textSize = 110f
        textPaint3.typeface = ResourcesCompat.getFont(this, R.font.satisfy)
        textPaint3.color = Color.rgb(6, 94, 105)
        val xPos3 = canvas.width / 2
        val yPos3 = 2000
        val textPaint7 = Paint(Paint.ANTI_ALIAS_FLAG)
        textPaint7.textAlign = Paint.Align.CENTER
        textPaint7.typeface = ResourcesCompat.getFont(this, R.font.playfairdisplayregular)
        textPaint7.color = Color.rgb(243, 242, 249)
        textPaint7.textSize = 150f

        val xPos7 = canvas.width / 2
        //    val yPos7 = 800
        //  canvas.drawText("FAITHHHHHHHHHHHH", xPos7.toFloat(), yPos7.toFloat(), textPaint7)
        // canvas.drawText("MOVES", xPos1, yPos1, textPaint7);
        //    canvas.drawText("MOUNTAINS", xPos2.toFloat(), yPos2.toFloat(), textPaint2)
        canvas.drawText("Matthew 17:20", xPos3.toFloat(), yPos3.toFloat(), textPaint3)


        val text =
            "TOURNAMENT NAME"
        val text1 =
            "Date:19/09/2022"
        val myTextPaint = TextPaint(TextPaint.ANTI_ALIAS_FLAG)
        myTextPaint.isAntiAlias = true
        //   myTextPaint.textSize = setTextSizeForWidth(myTextPaint, 800f, "TOURNAMENT NAME TOURNAMENT NAME")
        myTextPaint.textSize = 70f
        myTextPaint.typeface = ResourcesCompat.getFont(this, R.font.robotoc)

        myTextPaint.color = Color.rgb(243, 242, 249)
        myTextPaint.textAlign = Paint.Align.CENTER

        val width = 800
        val spacingMultiplier = 1f
        val spacingAddition = 0f
        val includePadding = false

        val builder = StaticLayout.Builder.obtain(text, 0, text.length, myTextPaint, width)
            .setAlignment(Layout.Alignment.ALIGN_CENTER)
            .setLineSpacing(spacingAddition, spacingMultiplier)
            .setIncludePad(includePadding)
            .setMaxLines(5)


        val myStaticLayout1 = builder.build()

        val builder1 = StaticLayout.Builder.obtain(text1, 0, text.length, myTextPaint, width)
            .setAlignment(Layout.Alignment.ALIGN_CENTER)
            .setLineSpacing(spacingAddition, spacingMultiplier)
            .setIncludePad(includePadding)
            .setMaxLines(5)


        val myStaticLayout2 = builder1.build()
//        imageView.setImageBitmap(overlay(bitmap2, myLogo));
        storageReference =
            FirebaseStorage.getInstance().getReference("images/" + "Running" + ".png")
        storageReference1 =
            FirebaseStorage.getInstance().getReference("images/" + "avenger" + ".jpeg")

        try {
            val localFile = File.createTempFile("tempFile", ".png")
            storageReference!!.getFile(localFile)
                .addOnSuccessListener {
                    var bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
                    var bitmapConfig1 = bitmap.config
                    if (bitmapConfig1 == null) {
                        bitmapConfig1 = Bitmap.Config.ARGB_8888
                    }
                    bitmap = bitmap.copy(bitmapConfig1, true)
                    val canvas1 = Canvas(bitmap)
                    val xPos2: Int = canvas1.width / 2
                    val yPos2 = 3750

                    canvas1.drawText(
                        text,
                        xPos2.toFloat(),
                        yPos2.toFloat(),
                        textPaint7
                    )
                    myStaticLayout1.draw(canvas1, 2500f, 4500f)
                    myStaticLayout2.draw(canvas1, 500f, 4500f)

                    imageView!!.setImageBitmap(bitmap)
                    button!!.setOnClickListener {

                        val convertedImage = getResizedBitmap(bitmap, 500)

                      //  uploadFile(getImageUri(this, bitmap))
                        uploadFile(getImageUri(this, convertedImage!!))

                    }
                }.addOnFailureListener {
                    Toast.makeText(
                        this@Second_activity,
                        "No",
                        Toast.LENGTH_SHORT
                    ).show()
                }
        } catch (e: IOException) {
            e.printStackTrace()
        }


    }

    private fun uploadFile(imagUri: Uri?) {
        if (imagUri != null) {

            val fileRef =
                storageReference!!.child("images").child(
                    System.currentTimeMillis()
                        .toString() + "."
                )

            fileRef.putFile(imagUri).addOnSuccessListener {
                fileRef.downloadUrl.addOnSuccessListener { uri1: Uri ->

                    val model = Upload(
                        uri1.toString(),
                    )
                    progressDialog!!.dismiss()

                    Toast.makeText(
                        this@Second_activity,
                        "Uploaded Successfully",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                }

            }
        }
    }

    fun getImageUri(inContext: Context, inImage: Bitmap): Uri? {
        val bytes = ByteArrayOutputStream()
        inImage.compress(Bitmap.CompressFormat.WEBP, 100, bytes)

        val format = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) Bitmap.CompressFormat.WEBP_LOSSLESS else Bitmap.CompressFormat.WEBP
        inImage.compress(format, 10, out)
        val path = MediaStore.Images.Media.insertImage(
            inContext.contentResolver,
            inImage,
            "Omanshu",
            null
        )
        return Uri.parse(path)
    }

    fun getResizedBitmap(image: Bitmap, maxSize: Int): Bitmap? {
        progressDialog!!.show()

        var width = image.width
        var height = image.height
        val bitmapRatio = width.toFloat() / height.toFloat()
        if (bitmapRatio > 1) {
            width = maxSize
            height = (width / bitmapRatio).toInt()
        } else {
            height = maxSize
            width = (height * bitmapRatio).toInt()
        }
        return Bitmap.createScaledBitmap(image, width, height, true)
    }


    private fun StaticLayout.draw(canvas: Canvas, x: Float, y: Float) {
        canvas.withTranslation(x, y) {
            draw(this)
        }
    }

    private fun overlay(bmp1: Bitmap, bmp2: Bitmap): Bitmap {
        val bmOverlay = Bitmap.createBitmap(bmp1.width, bmp1.height, bmp1.config)
        val canvas = Canvas(bmOverlay)
        canvas.drawBitmap(bmp1, Matrix(), null)
        canvas.drawBitmap(bmp2, 100f, 200f, null)
        return bmOverlay
    }

    companion object {
        private fun setTextSizeForWidth(
            paint: TextPaint, desiredWidth: Float,
            text: String
        ): Float {

            // Pick a reasonably large value for the test. Larger values produce
            // more accurate results, but may cause problems with hardware
            // acceleration. But there are workarounds for that, too; refer to
            // http://stackoverflow.com/questions/6253528/font-size-too-large-to-fit-in-cache
            val testTextSize = 58f

            // Get the bounds of the text, using our testTextSize.
            //  paint.setTextSize(testTextSize);
            val bounds = Rect()
            paint.getTextBounds(text, 0, text.length, bounds)

            val height = bounds.height()

            // Calculate the desired size as a proportion of our testTextSize.
            val desiredTextSize = testTextSize * desiredWidth / bounds.width()

            // Set the paint for that size.
            paint.textSize = desiredTextSize

            return paint.textSize
        }
    }
}