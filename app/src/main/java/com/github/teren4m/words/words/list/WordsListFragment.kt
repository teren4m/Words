package com.github.teren4m.words.words.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.teren4m.base.adapter.LastAdapter
import com.github.teren4m.base.mvvm.RouterMvvmFragment
import com.github.teren4m.words.BR
import com.github.teren4m.words.IRouter
import com.github.teren4m.words.R
import com.github.teren4m.words.databinding.FragmentWordsListBinding
import javax.inject.Inject

class WordsListFragment : RouterMvvmFragment<IRouter, IWordsListViewModel, FragmentWordsListBinding>() {

    override val routerId = BR.router

    override val viewModelId = BR.viewModel

    override val layoutId = R.layout.fragment_words_list

    @Inject
    lateinit var wordsConverter: WordsConverter

    @Inject
    lateinit var adapter: LastAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModelConverter = wordsConverter
        binding.list.layoutManager = LinearLayoutManager(activity)

        adapter.into(binding.list)
    }

}