package com.develop.dubhad.metacurrency.utils.extensions

import androidx.lifecycle.MutableLiveData
import com.develop.dubhad.metacurrency.base.models.Resource
import io.reactivex.Single
import io.reactivex.disposables.Disposable

fun <T> Single<T>.subscribeWithResource(
    resource: MutableLiveData<Resource<T>>,
    onLoading: (Disposable) -> Unit = { resource.postValue(Resource.loading()) },
    onError: (Throwable) -> Unit = { resource.postValue(Resource.error(it.localizedMessage)) },
    onSuccess: (T) -> Unit = { resource.postValue(Resource.success(it)) }
): Disposable {
    return this.doOnSubscribe(onLoading)
        .subscribe(onSuccess, onError)
}
