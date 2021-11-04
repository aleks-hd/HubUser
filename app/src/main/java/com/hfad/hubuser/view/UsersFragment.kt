package com.hfad.hubuser.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.hfad.hubuser.App
import com.hfad.hubuser.adapter.MainAdapter
import com.hfad.hubuser.databinding.FragmentUserBinding
import com.hfad.hubuser.model.GitRepo
import com.hfad.hubuser.presenter.UserListPresenter
import com.hfad.hubuser.request.RequestGitHubRepo
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UsersFragment : MvpAppCompatFragment(), UserView,BackBtnListener {

    val listPresenter: UserListPresenter by moxyPresenter {
        UserListPresenter(AndroidSchedulers.mainThread(),App.instance.router,RequestGitHubRepo(),ScreensPlay())
    }

    private var vb: FragmentUserBinding? = null

    var adapter: MainAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        vb = FragmentUserBinding.inflate(inflater, container, false)
        return vb?.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        initAdapter()
    }

    //вынести в интерфейс
    fun initAdapter() {
        vb?.run {
            this.recyclerContainer.layoutManager = LinearLayoutManager(context)
            adapter = MainAdapter(listPresenter)
            this.recyclerContainer.adapter = adapter

          // updateList()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = UsersFragment()
    }

    override fun onDestroyView() {
        super.onDestroyView()

    }

    override fun backPressed()= listPresenter.backClick()
    override fun updateList() {
      adapter?.notifyDataSetChanged()
    }
}