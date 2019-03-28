package com.averoes.daff.newsapp.adapter

import android.content.Context
import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.averoes.daff.newsapp.DetailActivity
import com.averoes.daff.newsapp.DetailActivity.Companion.AUTHOR
import com.averoes.daff.newsapp.DetailActivity.Companion.CONTENT
import com.averoes.daff.newsapp.DetailActivity.Companion.DATE
import com.averoes.daff.newsapp.DetailActivity.Companion.IMAGE
import com.averoes.daff.newsapp.DetailActivity.Companion.TITLE
import com.averoes.daff.newsapp.DetailActivity.Companion.URL
import com.averoes.daff.newsapp.R
import com.averoes.daff.newsapp.model.ArticlesItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_model.view.*
import org.jetbrains.anko.browse
import org.jetbrains.anko.intentFor
import org.jetbrains.anko.startActivity
import java.util.ArrayList

/**
 * Created by daff on 28/03/19 at 7:59.
 */
//todo 7 buat adapter untuk menampilkan data ke dalam list
class MyAdapter(val context: Context, val listitem: ArrayList<ArticlesItem?>?) :
    RecyclerView.Adapter<MyAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_model, parent, false)

        return Holder(view)
    }

    override fun getItemCount(): Int {
        return listitem!!.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindItem(listitem?.get(position)!!)

        //todo 8 buat listener untuk card view untuk berpindah ke DetailActivity
        holder.cardView.setOnClickListener {

//todo 9 mengirim data ke detail activity detail menggunakan anko commons
            context.startActivity(
                context.intentFor<DetailActivity>(

                    TITLE to listitem[position]!!.title,
                    AUTHOR to listitem[position]!!.author,
                    CONTENT to listitem[position]!!.content,
                    DATE to listitem[position]!!.publishedAt,
                    IMAGE to listitem[position]!!.urlToImage,
                    URL to listitem[position]!!.url
                )
            )
        }
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val judul = view.title_item
        val desk = view.desc_item
        val tanggal = view.date_item
        val gambar = view.img_item
        val cardView = view.card_view


        fun bindItem(item: ArticlesItem) {
            judul.text = item.title
            desk.text = item.description
            tanggal.text = item.publishedAt
            Picasso.get().load(item.urlToImage).into(gambar)

        }
    }
}