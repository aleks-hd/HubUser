package com.hfad.hubuser.presenter

import com.github.terrakok.cicerone.Router
import com.hfad.hubuser.view.IScreen
import com.hfad.hubuser.view.MainView
import moxy.MvpPresenter

class MainPresenter(val router: Router, val screen: IScreen): MvpPresenter<MainView>() {
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(screen.users())
    }
    fun backClick(){
        router.exit()
    }
}