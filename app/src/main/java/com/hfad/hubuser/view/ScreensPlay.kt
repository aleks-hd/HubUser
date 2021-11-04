package com.hfad.hubuser.view

import com.github.terrakok.cicerone.Screen
import com.github.terrakok.cicerone.androidx.FragmentScreen
import com.hfad.hubuser.model.User

class ScreensPlay:IScreen {
    override fun users(): Screen {
        return FragmentScreen{ UsersFragment.newInstance()}
    }

    override fun user(user:User): Screen {
        return FragmentScreen{UserItemFragment(user)}
    }
}