package xyz.tritin.reddin.common

import rx.Observable
import xyz.tritin.reddin.api.NewsApi
import xyz.tritin.reddin.api.NewsRestAPI

/**
 * <p>Date: 11.10.17</p>
 * @author Simon
 */
class NewsManager(private val api: NewsApi = NewsRestAPI()) {

    fun getNews(after: String, limit: String = "10"): Observable<RedditNews>{
        return Observable.create{
            subscriber ->
            val callResponse = api.getNews(after, limit)
            val response = callResponse.execute()

            if (response.isSuccessful){
                val dataResponse = response.body().data
                val news = dataResponse.children.map {
                    val item = it.data
                    RedditNewsItem(item.author, item.title, item.num_comments, item.created, item.thumbnail, item.url, item.score)
                }

                val redditNews = RedditNews(
                        dataResponse.after ?: "",
                        dataResponse.before ?: "",
                        news)

                subscriber.onNext(redditNews)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }

}