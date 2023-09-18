package com.tarantik.core.base.logging

import com.tarantik.core.base.logging.base.LogTag
import javax.inject.Inject
import timber.log.Timber

class TimberDebugTree @Inject constructor(
    private val logTag: LogTag,
) : Timber.DebugTree() {

    override fun createStackElementTag(element: StackTraceElement): String {
        return "${logTag.value}:(${element.fileName}:${element.lineNumber})#${element.methodName}"
    }
}
