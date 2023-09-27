package dev.danperez.typicode

import okhttp3.ResponseBody
import retrofit2.http.GET
import retrofit2.http.Path

// BaseUrl: https://jsonplaceholder.typicode.com
interface TypicodeService
{
    @GET("/posts/{postId}")
    suspend fun getPost(@Path("postId") postId: Int): ResponseBody
}