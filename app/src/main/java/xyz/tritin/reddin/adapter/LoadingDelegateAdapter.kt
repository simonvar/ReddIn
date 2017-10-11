package xyz.tritin.reddin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import xyz.tritin.reddin.R
import xyz.tritin.reddin.common.extensions.inflate

/**
 * <p>Date: 10.10.17</p>
 * @author Simon
 */
class LoadingDelegateAdapter : ViewTypeDelegateAdapter {
    override fun onCreateViewHolder(parent: ViewGroup) = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class TurnsViewHolder(parent: ViewGroup) :
            RecyclerView.ViewHolder(parent.inflate(R.layout.news_item_loading)){
    }
}