package com.hfad.hubuser.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hfad.hubuser.databinding.ItemBinding
import com.hfad.hubuser.model.User
import com.hfad.hubuser.presenter.UserListPresenter

class MainAdapter(val listPresenter: UserListPresenter):
    RecyclerView.Adapter<MainAdapter.ViewHolder>(){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.ViewHolder {
        return ViewHolder(ItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }

    override fun onBindViewHolder(holder: MainAdapter.ViewHolder, position: Int) {
        holder.bind(listPresenter.listUsers[position])


    }
    inner class ViewHolder(val vb : ItemBinding): RecyclerView.ViewHolder(vb.root) {
        fun bind(user: User) {
            vb.nameUser.let {
                 it.text = user.login
                it.setOnClickListener {
                    listPresenter.itemClick(user)
                }
            }

        }



    }
    override fun getItemCount() = listPresenter.listUsers.size

}