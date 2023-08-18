package com.mbakgun.mj.ui

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import org.koin.android.ext.android.get
import ui.MjImagesApp

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setComposable()
    }

    private fun setComposable() {
        setContent {
            MjImagesApp(
                viewModel = get()
            )
        }
    }
}
