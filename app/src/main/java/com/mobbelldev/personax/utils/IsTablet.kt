package com.mobbelldev.personax.utils

import android.content.Context

fun Context.isTabletLayout(): Boolean {
    return resources.configuration.screenWidthDp >= 600
}

