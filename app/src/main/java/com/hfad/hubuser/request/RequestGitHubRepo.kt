package com.hfad.hubuser.request

import com.hfad.hubuser.model.User
import io.reactivex.rxjava3.core.Single

class RequestGitHubRepo(val requestGutHub: RequestApiUsers = RequestApiUsers()):IGitHubUserRepo {
    override fun getUsers(): Single<List<User>> {
       return requestGutHub.getRequest().loadUsers()
    }


}