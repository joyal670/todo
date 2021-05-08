package com.mytodo.mytodo.base

import android.app.Application
import com.mytodo.mytodo.R
import com.mytodo.mytodo.utils.AppPreferences

class MyApp :Application()
{
    override fun onCreate() {
        super.onCreate()
        AppPreferences.init(this)

    }

}