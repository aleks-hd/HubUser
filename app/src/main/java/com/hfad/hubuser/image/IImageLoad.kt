package com.hfad.hubuser.image


interface IImageLoad<T> {
    fun loadInto(url:String, container: T)
}