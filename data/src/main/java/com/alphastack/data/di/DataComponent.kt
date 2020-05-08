package com.alphastack.data.di

import com.alphastack.data.SampleClass
import dagger.Component

@DataScope
@Component(modules = [DataModule::class])
interface DataComponent {

    fun provideSampleClass(): SampleClass

}