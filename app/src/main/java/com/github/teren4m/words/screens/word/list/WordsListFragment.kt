package com.github.teren4m.words.screens.word.list

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.teren4m.base.adapter.LastAdapter
import com.github.teren4m.base.mvvm.RouterBindMvvmFragment
import com.github.teren4m.words.BR
import com.github.teren4m.words.IRouter
import com.github.teren4m.words.R
import com.github.teren4m.words.databinding.FragmentWordsListBinding
import com.github.teren4m.words.screens.activity.main.IMainViewModel
import com.github.teren4m.words.screens.activity.main.modes.ModeType
import javax.inject.Inject

class WordsListFragment : RouterBindMvvmFragment<IRouter, IWordsListViewModel, FragmentWordsListBinding>() {

    override val routerId = BR.router

    override val viewModelId = BR.viewModel

    override val layoutId = R.layout.fragment_words_list

    @Inject
    lateinit var wordsConverter: WordsConverter

    @Inject
    lateinit var adapter: LastAdapter

    @Inject
    lateinit var mainViewModel: IMainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModelConverter = wordsConverter
        binding.list.layoutManager = LinearLayoutManager(activity)

        adapter.into(binding.list)
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.startMode(ModeType.MAIN)
    }


}