package com.rishav.mymovies

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.animation.LinearInterpolator
import android.widget.LinearLayout
import android.widget.Toast
import com.rishav.mymovies.adapter.PopularAdapter
import com.rishav.mymovies.model.popular.Popular
import com.rishav.mymovies.model.popular.Results
import com.rishav.mymovies.network.RetrofitHelper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_popular.*
import java.io.LineNumberReader

class PopularActivity : AppCompatActivity() {
    private lateinit var popularAdapter: PopularAdapter
    private lateinit var resultsList: ArrayList<Results>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_popular)

        getData()
        initRecyclerView()
    }

    private fun initRecyclerView() {
        recyclerviewPopular.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerviewPopular.setHasFixedSize(true)
        recyclerviewPopular.isNestedScrollingEnabled = true
        resultsList = ArrayList()
        popularAdapter = PopularAdapter(this, resultsList)
        recyclerviewPopular.adapter = popularAdapter
    }

    private fun getData() {
        val retrofitHelper = RetrofitHelper()

        val popularCall = retrofitHelper.getApiService().getPopularList()
        popularCall.enqueue(object : Callback<Popular> {
            override fun onResponse(call: Call<Popular>?, response: Response<Popular>) {
                if (response.isSuccessful) {
                    val popular = response.body()
                    val resultsList: List<Results>? = popular?.results
                    val totalPages: Int? = popular?.totalResults
                    Log.d("test", totalPages.toString())
//                    if (popularList != null) {
//                        Log.e("Test", popularList[5].title)
//                    }

                    populateRecyclerView(resultsList)
                }
                else{
                    Toast.makeText(this@PopularActivity, "Opps! Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Popular>?, t: Throwable?) {
                Toast.makeText(this@PopularActivity, "No Internet Connection", Toast.LENGTH_SHORT).show()
            }

        })
    }

    private fun populateRecyclerView(resultsList: List<Results>?){
        if (resultsList != null){
            this.resultsList.clear()
            this.resultsList.addAll(resultsList)
            popularAdapter.notifyDataSetChanged()
        }
    }


}
