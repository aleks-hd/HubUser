package com.hfad.hubuser.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hfad.hubuser.App
import com.hfad.hubuser.databinding.FragmentUserItemBinding
import com.hfad.hubuser.image.GlideImageLoad
import com.hfad.hubuser.model.User
import com.hfad.hubuser.presenter.UserPresenter
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserItemFragment(val user: User) : MvpAppCompatFragment(), UsView,BackBtnListener {

    private var vb: FragmentUserItemBinding? = null

    private val presenter by moxyPresenter {
        UserPresenter(App.instance.router, user)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentUserItemBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vb?.nameUserItem?.text = user.login
        vb?.imageCard?.let { GlideImageLoad().loadInto(user.avatarUrl.toString(), it) }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        vb = null
    }

    override fun backPressed(): Boolean {
       presenter.backClick()
        return true
    }


}
