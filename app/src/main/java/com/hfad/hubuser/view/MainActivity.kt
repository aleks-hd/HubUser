package com.hfad.hubuser.view

import android.os.Bundle
import com.github.terrakok.cicerone.androidx.AppNavigator
import com.hfad.hubuser.App
import com.hfad.hubuser.R
import com.hfad.hubuser.databinding.ActivityMainBinding
import com.hfad.hubuser.presenter.MainPresenter
import moxy.MvpAppCompatActivity

import moxy.ktx.moxyPresenter

class MainActivity : MvpAppCompatActivity(),MainView {

    val navigator = AppNavigator(this, R.id.fragment_container)


    private val presenter by moxyPresenter {
        MainPresenter(App.instance.router, ScreensPlay())
    }
    private var vb: ActivityMainBinding? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       vb = ActivityMainBinding.inflate(layoutInflater)
        setContentView(vb?.root)
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.instance.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        App.instance.navigatorHolder.removeNavigator()
    }
}