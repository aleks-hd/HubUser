package com.hfad.hubuser.view

import com.github.terrakok.cicerone.Screen
import com.hfad.hubuser.model.User

interface IScreen {
    fun users():Screen
    fun user(user:User):Screen

}