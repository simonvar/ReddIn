package xyz.tritin.reddin.api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * <p>Date: 11.10.17</p>
 * @author Simon
 */
interface RedditApi {
    @GET("/top.json")
    fun getTop(@Query("after") after: String, @Query("limit") limit: String) : Call<RedditNewsResponse>
}