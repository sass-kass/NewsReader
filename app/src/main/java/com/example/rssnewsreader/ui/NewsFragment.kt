package com.example.rssnewsreader.ui

import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import com.example.rssnewsreader.R
import com.example.rssnewsreader.databinding.NewsFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsFragment: Fragment() {
    private var _binding: NewsFragmentBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var adapter: NewsAdapter

    private val viewModel: NewsViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        setHasOptionsMenu(true)

        _binding = NewsFragmentBinding.inflate(inflater, container, false)

        val divider = DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
        binding.newsRecyclerview.addItemDecoration(divider)
        binding.newsRecyclerview.adapter = adapter

        viewModel.currentNews.observe(viewLifecycleOwner){news ->
            if(news != null) {
                adapter.submitList(news.channel.itemList)
            }
        }

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()

        inflater.inflate(R.menu.menu, menu)

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_refresh -> {
                viewModel.getNews()
                return true
            }
            else -> {}
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()
        (activity as AppCompatActivity).supportActionBar?.title = "News"
    }
}