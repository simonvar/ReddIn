package xyz.tritin.reddin.api

import retrofit2.Call

/**
 * <p>Date: 11.10.17</p>
 * @author Simon
 */
interface NewsApi {
    fun getNews(after: String, limit: String): Call<RedditNewsResponse>
}