package com.rishav.mymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.rishav.mymovies.model.latest.Genres
import com.rishav.mymovies.model.latest.Latest
import com.rishav.mymovies.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import kotlinx.android.synthetic.main.activity_latest.*

class LatestActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_latest)

        getData()
    }

    private fun getData() {
        val retrofitHelper = RetrofitHelper()

        val latestCall = retrofitHelper.getApiService().getLatest()
        latestCall.enqueue(object : Callback<Latest> {
            override fun onResponse(call: Call<Latest>?, response: Response<Latest>) {
                if (response.isSuccessful) {
                    val latest = response.body()
                    val overview: String? = latest?.overview
                    if (overview != null) {
                        Log.d("test", overview)
                        text.text = overview
                    }

                }
            }

            override fun onFailure(call: Call<Latest>?, t: Throwable?) {
                Toast.makeText(this@LatestActivity, t?.message, Toast.LENGTH_LONG).show()
            }
        })

    }
}
