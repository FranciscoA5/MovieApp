package ipca.budget.movieapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import org.json.JSONObject

class MovieSeriesDetail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_series_detail)

        val movieImdb = MovieandSeries.fromJSON(JSONObject(intent.getStringExtra(MainActivity.EXTRA_ARTICLE_STRING)))

        title = movieImdb.title

        movieImdb.url?.let {
            findViewById<WebView>(R.id.webview).loadUrl(it)
        }

    }
}