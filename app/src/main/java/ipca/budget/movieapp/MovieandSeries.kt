package ipca.budget.movieapp

import org.json.JSONObject

class MovieandSeries {
    var title       : String? = null
    var url         : String? = null
    var urlToImage  : String? = null
    var isFavourite = false

    fun toJSON() : JSONObject {
        val jsonObject = JSONObject()
        jsonObject.put("name"      , title      )
        jsonObject.put(jsonObject.getJSONObject("external_ids").getJSONObject("imdb").getString("url")  , url )
      // jsonObject.put("publishedAt", publishedAt?.toServerDateString())
      // jsonObject.put("content"    , content    )
        jsonObject.put("urlToImage" , urlToImage )

        return jsonObject
    }

    companion object {
        fun fromJSON(jsonObject: JSONObject) : MovieandSeries {
            return MovieandSeries().apply {
                title       = jsonObject.getString("name"      )
                url         = jsonObject.getJSONObject("external_ids").getJSONObject("imdb").getString("url")
                val url2 = url
                println(url2)
                //publishedAt = jsonObject.getString("publishedAt").parseDate()
                //content     = jsonObject.getString("content"    )
                urlToImage  = jsonObject.getString("picture")
            }
        }
    }
}