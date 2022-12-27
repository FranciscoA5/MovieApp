package ipca.budget.movieapp

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Request
import okhttp3.OkHttpClient

object BackEnd {
//    private val client = OkHttpClient()
//
//    fun requestMovieAPI(scope: CoroutineScope) {
//        scope.launch(Dispatchers.IO) {
//            val request = Request.Builder()
//                .url("https://utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com/lookup?term=bojack&country=uk")
//                .get()
//                .addHeader("X-RapidAPI-Key", "d00f3fb5edmsh16e0248d8afd00bp1f940ajsn4aec02b20ad7")
//                .addHeader(
//                    "X-RapidAPI-Host",
//                    "utelly-tv-shows-and-movies-availability-v1.p.rapidapi.com"
//                )
//                .build()
//
//            val response = client.newCall(request).execute().use {
//                println("ola")
//                println(it.body!!.string())
//            }
//        }
//    }

}