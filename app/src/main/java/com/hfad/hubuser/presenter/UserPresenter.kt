package com.hfad.hubuser.presenter

import com.github.terrakok.cicerone.Router
import com.hfad.hubuser.databinding.FragmentUserItemBinding
import com.hfad.hubuser.image.GlideImageLoad
import com.hfad.hubuser.model.User
import com.hfad.hubuser.view.UserView
import moxy.MvpPresenter
//пока не нужен
class UserPresenter(val router: Router, val user:User): MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

         }

    fun backClick(){
        router.exit()
    }
}