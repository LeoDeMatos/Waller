package br.com.leonardo.waller.view.adapter.viewHolder

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.leonardo.core.model.User
import br.com.leonardo.waller.R
import com.bumptech.glide.Glide

/**
 * Created by Leonardo on 03/09/17.
 */
class UserInfoViewHolder(view: View): RecyclerView.ViewHolder(view){

    private val userImageView: ImageView = view.findViewById(R.id.user_image_view)
    private val userNameTextView: TextView = view.findViewById(R.id.user_name_text_view)
    private val userDescriptionTextView: TextView = view.findViewById(R.id.user_description_text_view)

    fun configure(user: User){
        userNameTextView.text = user.name
        userDescriptionTextView.text = user.bio
        Glide.with(itemView.context)
                .load(user.profile_image.large)
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(userImageView)
    }
}