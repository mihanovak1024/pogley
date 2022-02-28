package com.mihanovak1024.pogley.util

import timber.log.Timber
import javax.inject.Inject

class TimberDebugTree @Inject constructor() : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement) =
        "<mn1024> ${super.createStackElementTag(element)}"
}