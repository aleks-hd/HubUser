package com.hfad.hubuser.image

import android.widget.ImageView
import com.bumptech.glide.Glide

class GlideImageLoad:IImageLoad<ImageView>{
    override fun loadInto(url: String, container: ImageView) {
        Glide.with(container.context)
            .load(url)
            .into(container)
    }

}