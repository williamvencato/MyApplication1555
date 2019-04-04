package com.example.myapplication

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Toast
import android.graphics.Bitmap
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener{
            abrirCamera()
        }
    }


    fun abrirCamera(){
        val intent = Intent("android.media.action.IMAGE_CAPTURE")
        startActivityForResult(intent, 0)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                if (data != null) {
                    val bundle = data.extras
                    val bitmap = bundle!!.get("data") as Bitmap
                } else if (resultCode == RESULT_CANCELED) {
                    Toast.makeText(
                        baseContext, "Captura cancelada",
                        Toast.LENGTH_SHORT
                    )
                } else {
                    Toast.makeText(
                        baseContext, "Usuário fechou a câmera!",
                        Toast.LENGTH_SHORT
                    )
                }
            }
        }
    }

}
