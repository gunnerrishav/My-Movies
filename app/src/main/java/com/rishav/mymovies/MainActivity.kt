package com.rishav.mymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.rishav.mymovies.model.Movies
import com.rishav.mymovies.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Response
import javax.security.auth.callback.Callback

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
    }


    //Api call
    private fun getData() {
        val retrofitHelper = RetrofitHelper()

        val moviesCall = retrofitHelper.getApiService().getMovieList()
        moviesCall.enqueue(object : retrofit2.Callback<Movies> {
            override fun onResponse(call: Call<Movies>?, response: Response<Movies>) {
                if (response.isSuccessful){
                    val movies = response.body()
                    if (movies != null && movies.results!= null) {
                        Log.d("title", movies.results[5].title)
                        textTitleStatic.text = movies.results[2].title
                    }

                }
            }

            override fun onFailure(call: Call<Movies>, t: Throwable) {
                Toast.makeText(this@MainActivity,t.message,Toast.LENGTH_SHORT).show()
            }

        })
    }
}

