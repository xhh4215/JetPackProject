package com.xdzl.golden.mango.application.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import com.xdzl.golden.mango.application.entity.HandleResponse
import com.xdzl.golden.mango.application.entity.LoginResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

private const val BASE_URL = "http://192.168.1.54:8000/"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object GoldenMangoApi {
    val retrofitService: GoldenMangoServices by lazy {
        retrofit.create(GoldenMangoServices::class.java)
    }
}

interface GoldenMangoServices {
    @FormUrlEncoded
    @POST("api/machine/handheld/login")
    suspend fun login(
        @Field("userName") username: String,
        @Field("passWord") password: String
    ): LoginResponse

    @FormUrlEncoded
    @POST("api/machine/handheld/getPowerHandheldList")
    suspend fun userHandle(@Field("userId") userId: String): HandleResponse

    @FormUrlEncoded
    @POST("api/machine/handheld/inStock")
    suspend fun inStock()
}