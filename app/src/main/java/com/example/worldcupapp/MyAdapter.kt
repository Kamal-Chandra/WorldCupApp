package com.example.worldcupapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class MyAdapter(private val context: Context, private val items: ArrayList<CountryModel>) : BaseAdapter() {

    override fun getCount(): Int {
        return items.size
    }

    override fun getItem(position: Int): CountryModel {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            view = inflater.inflate(R.layout.list_item_layout, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
        }

        val country = items[position]
        viewHolder.txtName?.text = country.name
        viewHolder.txtCupWin?.text = country.cupsWins

        //  Modifies rectangular image to circular image
        viewHolder.flagImg?.let {
            Glide.with(context)
                .load(country.flagImg)
                .apply(RequestOptions.circleCropTransform())
                .into(it)
        }
        return view
    }

    private class ViewHolder(row: View) {
        var txtName: TextView? = row.findViewById(R.id.countryName)
        var txtCupWin: TextView? = row.findViewById(R.id.wins)
        var flagImg: ImageView? = row.findViewById(R.id.imageView)
    }
}