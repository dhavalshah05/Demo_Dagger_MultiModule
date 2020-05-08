package com.alphastack.multimoduledemo.di

import com.alphastack.data.di.DataComponent
import com.alphastack.multimoduledemo.MainActivity
import dagger.Component

@ApplicationScope
@Component(dependencies = [DataComponent::class], modules = [ApplicationModule::class])
interface ApplicationComponent {

    fun inject(activity: MainActivity)

}