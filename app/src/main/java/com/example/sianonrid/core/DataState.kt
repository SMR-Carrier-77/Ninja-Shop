package com.example.sianonrid.core

import android.os.Message

sealed class DataState<T>(
    var message: String?=null,
    var data:T?=null
) {
    class Loading<T>: DataState<T>()
    class Success<T>(data:T?): DataState<T>(data=data)
    class Error<T>(message: String?): DataState<T>(message)
}