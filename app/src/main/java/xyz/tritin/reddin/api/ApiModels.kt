package xyz.tritin.reddin.api

/**
 * <p>Date: 11.10.17</p>
 * @author Simon
 */
class RedditNewsResponse(val data: RedditDataResponse)

class RedditDataResponse(
        val children: List<RedditChildrenResponse>,
        val after: String?,
        val before: String?
)

class RedditChildrenResponse(val data: RedditNewsDataResponse)

class RedditNewsDataResponse(
        val author: String,
        val title: String,
        val num_comments: Int,
        val created: Long,
        val thumbnail: String,
        val url: String,
        val score: Int
)