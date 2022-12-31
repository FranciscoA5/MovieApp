package ipca.budget.movieapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Spannable.Factory
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.lifecycle.lifecycleScope

class MainActivity : AppCompatActivity() {

    var movies = arrayListOf<MovieandSeries>()
    val adapter = MovieAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val movie1 = MovieandSeries()
        val movie2 = MovieandSeries()
        movie1.title = "Cars"
        movie2.title = "Cars2"
        movies.add(movie1)
        movies.add(movie2)

        findViewById<ListView>(R.id.MovieList).adapter = adapter
        //BackEnd.requestMovieAPI(lifecycleScope)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu1,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        return when(item.itemId){
            R.id.favourites -> {
                val intent = Intent(this@MainActivity, Favorites::class.java)
                startActivity(intent)
                return true
            }

            R.id.wishlist -> {
                val intent = Intent(this@MainActivity, Wishlist::class.java)
                startActivity(intent)
                return true
            }

            else -> {
                return false
            }
        }
    }

    inner class MovieAdapter : BaseAdapter() {
        override fun getCount(): Int {
            return movies.size
        }

        override fun getItem(position: Int): Any {
            return movies[position]
        }

        override fun getItemId(position: Int): Long {
            return 0
        }

        override fun getView(position: Int, view: View?, p2: ViewGroup?): View {
            val rootView = layoutInflater.inflate(R.layout.row_moviesandseries,p2,false)

            val textViewMovieTitle = rootView.findViewById<TextView>(R.id.MovieTitle)
            val imageViewMovieImage = rootView.findViewById<ImageView>(R.id.MovieImage)
            val toggleButton =  rootView.findViewById<ToggleButton>(R.id.favbutton);

            textViewMovieTitle.text = movies[position].title

            toggleButton.setOnCheckedChangeListener { _, isChecked ->
                if (isChecked) {
                    // The toggle is enabled
                } else {
                    // The toggle is disabled
                }
            }



            //imageViewMovieImage.text = movies[position].title

//            articles[position].urlToImage?.let {
//                Backend.fetchImage(lifecycleScope, it){ bitmap ->
//                    imageViewArticleImage.setImageBitmap(bitmap)
//                }
//            }

//            rootView.setOnClickListener {
//                Log.d("MainActivity", articles[position].title?:"" )
//                //val intent = Intent(this@MainActivity, ArticleDetailActivity::class.java)
//                //intent.putExtra("title", articles[position].title)
//                //intent.putExtra("body", articles[position].content)
//
//                val intent = Intent(this@MainActivity, ArticleWebDetailActivity::class.java)
//                intent.putExtra(EXTRA_ARTICLE_STRING, articles[position].toJSON().toString() )
//                startActivity(intent)
//
//            }


            return rootView
        }
    }
}