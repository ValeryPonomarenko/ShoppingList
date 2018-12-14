package me.vponomarenko.shoppinglist.list.recycler

import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.*

/**
 * Author: Valery Ponomarenko
 * Date: 13/12/2018
 * LinkedIn: https://www.linkedin.com/in/ponomarenkovalery
 */

class ShoppingItemAnimator : DefaultItemAnimator() {

    init {
        supportsChangeAnimations = false
    }

    override fun animateChange(
        oldHolder: RecyclerView.ViewHolder,
        newHolder: RecyclerView.ViewHolder,
        preInfo: ItemHolderInfo,
        postInfo: ItemHolderInfo
    ): Boolean {
        if (newHolder is ShoppingItemViewHolder) {
            newHolder.lottie_animation.cancelAnimation()
            if (newHolder.isChecked) {
                newHolder.lottie_animation.playAnimation()
            } else {
                newHolder.lottie_animation.progress = 0f
            }
            return false
        }
        return super.animateChange(oldHolder, newHolder, preInfo, postInfo)
    }

    override fun animateAdd(holder: RecyclerView.ViewHolder): Boolean {
        return false
    }

    override fun animateRemove(holder: RecyclerView.ViewHolder): Boolean {
        holder.itemView.alpha = 0f
        return false
    }
}