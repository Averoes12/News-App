package com.averoes.daff.newsapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.averoes.daff.newsapp.adapter.MyAdapter
import com.averoes.daff.newsapp.model.ArticlesItem
import com.averoes.daff.newsapp.model.ResponseNews
import com.averoes.daff.newsapp.network.ConfigRetrofit
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //todo 7 panggil configurasi retrofit

        val request = ConfigRetrofit().getRequest()

        //todo 8 ambil data dari server
        request.getDataServer().enqueue(object : Callback<ResponseNews> {
            //ketika response gagal
            override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                toast("Response Failure")
                error("Response Failure")
            }

            //ketika response succes
            override fun onResponse(call: Call<ResponseNews>, response: Response<ResponseNews>) {

                toast("Succes")
                showList(response.body()?.articles)
            }
        })

    }



    private fun showList(data: ArrayList<ArticlesItem?>?) {

        recycler.adapter = MyAdapter(this, data)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.setHasFixedSize(true)
    }
}
