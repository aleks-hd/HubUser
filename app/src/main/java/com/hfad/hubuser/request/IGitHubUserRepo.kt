package com.hfad.hubuser.request

import com.hfad.hubuser.model.User
import io.reactivex.rxjava3.core.Single

interface IGitHubUserRepo {
    fun getUsers(): Single<List<User>>
}