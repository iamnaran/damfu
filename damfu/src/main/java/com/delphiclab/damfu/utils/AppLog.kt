package com.delphiclab.damfu.utils

import android.util.Log

class AppLog private constructor() {
    companion object {
        fun showDebug(tag: String, message: String) {
            Log.e(tag,"$--->$message")
        }

        fun showLog(message: String) {
            Log.e("showlog show log","$--->$message")
        }

        fun showError(tag: String, message: String) {
            Log.e(tag,"$--->$message")
        }

        fun showException(throwable: Throwable, message: String, vararg args: Any?) {
            Log.e(" tag exception ","$--->$message")
        }

        fun tagFor(clazz: Class<*>): String {
            return clazz.simpleName
        }

    }
}