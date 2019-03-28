package com.averoes.daff.newsapp

import android.annotation.SuppressLint
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import org.jetbrains.anko.browse

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)


        showDetailNews()


    }

    fun showDetailNews(){

        val intent = getIntent()

        title_detail.text = intent.getStringExtra(TITLE)
        author_detail.text = intent.getStringExtra(AUTHOR)
        date_detail.text = intent.getStringExtra(DATE)
        content_detail.text = intent.getStringExtra(CONTENT)

        see_detail.setOnClickListener {
            browse(intent.getStringExtra(URL))
        }

        Picasso.get().load(intent.getStringExtra(IMAGE)).into(img_detail)

    }

    companion object {
        val TITLE = "title"
        val AUTHOR = "author"
        val CONTENT = "content"
        val DATE = "date"
        val IMAGE = "image"
        val URL = "url"
    }
}
