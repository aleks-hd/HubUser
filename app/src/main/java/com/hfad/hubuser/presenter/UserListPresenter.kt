package com.hfad.hubuser.presenter

import android.util.Log
import androidx.annotation.MainThread
import com.github.terrakok.cicerone.Router
import com.hfad.hubuser.App
import com.hfad.hubuser.model.GitRepo
import com.hfad.hubuser.model.IItemClick
import com.hfad.hubuser.model.User
import com.hfad.hubuser.request.IGitHubUserRepo
import com.hfad.hubuser.view.IScreen
import com.hfad.hubuser.view.ScreensPlay
import com.hfad.hubuser.view.UserView
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter

class UserListPresenter(val uiSchedulers: Scheduler,val router: Router, val gitRepo: IGitHubUserRepo, val screen:IScreen) :MvpPresenter<UserView>(),IItemClick {

val listUsers = mutableListOf<User>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        loadData()
    }

    override fun itemClick(user: User) {
       Log.i("CLICK","click $user")

       router.navigateTo(screen.user(user))

    }

   fun  loadData(){
       gitRepo.getUsers()
           .observeOn(uiSchedulers)
           .subscribe({
               repor -> listUsers.addAll(repor)

            viewState.updateList()
           },{
               println("Error: ${it.message}")
           })
   }

    fun backClick():Boolean{
        router.exit()
        return true
    }


}