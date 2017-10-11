package xyz.tritin.reddin.api

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

/**
 * <p>Date: 11.10.17</p>
 * @author Simon
 */
class NewsRestAPI : NewsApi {
    private val redditApi: RedditApi

    init {
        val retrofit = Retrofit.Builder()
                .baseUrl("https://www.reddit.com")
                .addConverterFactory(MoshiConverterFactory.create())
                .build()

        redditApi = retrofit.create(RedditApi::class.java)
    }

    override fun getNews(after: String, limit: String): Call<RedditNewsResponse>{
        return redditApi.getTop(after, limit)
    }
}