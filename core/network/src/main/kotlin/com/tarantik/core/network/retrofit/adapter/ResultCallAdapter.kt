package com.tarantik.core.network.retrofit.adapter

import ResultCall
import com.squareup.moshi.Moshi
import com.tarantik.core.base.arch.Result
import com.tarantik.core.network.NetworkContract
import java.lang.reflect.Type
import retrofit2.Call
import retrofit2.CallAdapter

class ResultCallAdapter<R>(
    private val resultType: Type,
    private val moshi: Moshi,
    private val networkContract: NetworkContract,
) : CallAdapter<R, Call<Result<R>>> {

    override fun responseType(): Type = resultType

    override fun adapt(call: Call<R>): Call<Result<R>> = ResultCall(call, resultType, moshi, networkContract)
}
