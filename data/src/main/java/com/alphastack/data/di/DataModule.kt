package com.alphastack.data.di

import com.alphastack.data.SampleClass
import dagger.Module
import dagger.Provides

@Module
class DataModule {

    @Provides
    @DataScope
    fun provideSampleClass(): SampleClass {
        return SampleClass()
    }

}