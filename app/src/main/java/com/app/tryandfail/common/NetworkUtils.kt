package com.app.tryandfail.common

import org.json.JSONObject
import retrofit2.Response

object NetworkUtils {
    suspend fun<T> process( api:suspend() -> Response<T>):ApiResponse<T>{
        val response = api()
        return if(response.isSuccessful){
            ApiResponse.Success(response.body()!!,response.code(),response.message())
        }else{
            val rawRes = response.errorBody()?.string() ?: "{}"
            val json = JSONObject(rawRes)
            val m = json.optString("message")
            ApiResponse.Failure(m,response.code())
        }
    }
}

sealed class ApiResponse<out T>{
    data class Success<out T>(val data:T,val code:Int,val message: String) : ApiResponse<T>()
    data class Failure(val message:String,val code:Int) : ApiResponse<Nothing>()
}