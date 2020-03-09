package com.airoks.tbusschedulenew.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel(
    private val contextProvider: CoroutineContextProvider
) : ViewModel() {

    private val handler = CoroutineExceptionHandler { _, throwable ->
        onError(throwable)
    }

    open fun onError(throwable: Throwable) {
        Log.e("ViewModel", "Error ${throwable.message}")
    }

    protected fun io(block: CoroutineScope.() -> Unit): Job =
        viewModelScope.launch(handler + contextProvider.IO) { block.invoke(this) }

    protected fun ui(block: CoroutineScope.() -> Unit): Job =
        viewModelScope.launch(handler + contextProvider.Main) { block.invoke(this) }
}
