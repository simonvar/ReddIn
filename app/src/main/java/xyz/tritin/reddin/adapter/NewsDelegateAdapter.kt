package xyz.tritin.reddin.adapter

import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.ViewGroup
import kotlinx.android.synthetic.main.news_item.view.*
import xyz.tritin.reddin.R
import xyz.tritin.reddin.common.RedditNewsItem
import xyz.tritin.reddin.common.extensions.getFriendlyTime
import xyz.tritin.reddin.common.extensions.inflate
import xyz.tritin.reddin.common.extensions.loadImg
import android.widget.Toast
import android.content.ActivityNotFoundException
import android.support.v4.content.ContextCompat.startActivity
import android.content.Intent
import android.net.Uri
import android.support.design.widget.Snackbar


/**
 * <p>Date: 10.10.17</p>
 * @author Simon
 */
class NewsDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder = TurnsViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as TurnsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    class TurnsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.news_item)) {
        fun bind(item: RedditNewsItem) = with(itemView){

            itemView.setOnClickListener {
                var url = item.url
                if (!url.startsWith("http://") && !url.startsWith("https://"))
                    url = "http://" + url;

                try {
                    val UrlIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                    startActivity(context, UrlIntent, null)
                } catch (e: ActivityNotFoundException) {
                    Snackbar.make(description, "No application can handle this request." + " Please install a webbrowser", Snackbar.LENGTH_LONG).show()
                    e.printStackTrace()
                }

            }

            img_thumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = item.author
            comments.text = "${item.numComments} comments"
            time.text = item.created.getFriendlyTime()
            score.text = "${item.score} score"
        }
    }

}