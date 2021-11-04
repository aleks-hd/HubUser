package com.hfad.hubuser.request

import com.hfad.hubuser.model.User
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface IDataSource {
    @GET("users")
    fun loadUsers():Single<List<User>>

    @GET("users/{login}")
    fun loadUser(@Path("login") login: String): Single<User>
}