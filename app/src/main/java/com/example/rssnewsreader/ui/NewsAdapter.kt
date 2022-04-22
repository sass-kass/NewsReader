package com.example.rssnewsreader.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.rssnewsreader.R
import com.example.rssnewsreader.network.Item
import dagger.hilt.android.scopes.FragmentScoped
import javax.inject.Inject

@FragmentScoped
class NewsAdapter @Inject constructor() : ListAdapter<Item, NewsAdapter.ViewHolder>(NewsComparator()) {

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val icon: ImageView = view.findViewById(R.id.item_icon)
        val title: TextView = view.findViewById(R.id.item_title)
        val description: TextView = view.findViewById(R.id.item_description)
        val link: TextView = view.findViewById(R.id.item_link)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.news_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)
        if(item.img.img == "")
            viewHolder.icon.load(R.drawable.no_image_available_svg)
        else
            viewHolder.icon.load(item.img.img)
        viewHolder.title.text = item.title
        viewHolder.description.text = item.description[0].description
        if (item.guid.isPermaLink) {
            val str = "Link: " + item.guid.link
            viewHolder.link.text = str
        } else {
            val str = "No lin available "
            viewHolder.link.text = str
        }
    }

    class NewsComparator: DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean {
            return oldItem == newItem
        }
    }

}