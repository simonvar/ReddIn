package xyz.tritin.reddin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * <p>Date: 10.10.17</p>
 * @author Simon
 */

interface ViewTypeDelegateAdapter {
    fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder

    fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType)
}