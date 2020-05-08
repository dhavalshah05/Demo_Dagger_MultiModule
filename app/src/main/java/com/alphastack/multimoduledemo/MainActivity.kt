package com.alphastack.multimoduledemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.alphastack.data.SampleClass
import com.alphastack.data.di.DaggerDataComponent
import com.alphastack.data.di.DataModule
import com.alphastack.multimoduledemo.di.ApplicationModule
import com.alphastack.multimoduledemo.di.DaggerApplicationComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var sampleClass: SampleClass

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // create DataComponent
        val dataComponent = DaggerDataComponent.builder()
            .dataModule(DataModule())
            .build()

        // Create Application Component
        val applicationComponent = DaggerApplicationComponent.builder()
            .dataComponent(dataComponent)
            .applicationModule(ApplicationModule())
            .build()

        // Inject
        applicationComponent.inject(this)

        Log.d("MainActivity", "SampleClass Injected $sampleClass")
    }
}
