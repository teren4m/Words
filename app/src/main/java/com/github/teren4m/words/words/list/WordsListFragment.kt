package com.github.teren4m.words.words.list

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.LinearLayoutManager
import com.github.teren4m.base.adapter.LastAdapter
import com.github.teren4m.base.mvvm.MvvmFragment
import com.github.teren4m.base.observe
import com.github.teren4m.words.BR
import com.github.teren4m.words.IFragmentNavigation
import com.github.teren4m.words.R
import com.github.teren4m.words.words.list.item.HebrewWordViewModel
import com.github.teren4m.words.words.list.item.IHebrewWordViewModel
import com.github.teren4m.words.words.list.model.WordItem
import dagger.Lazy
import kotlinx.android.synthetic.main.fragment_words_list.*
import javax.inject.Inject

class WordsListFragment : MvvmFragment<IWordsListViewModel, ViewDataBinding>() {

    override val viewModelId = BR.viewModel

    override val layoutId = R.layout.fragment_words_list

    @Inject
    lateinit var fragmentNavigation: Lazy<IFragmentNavigation>

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = LastAdapter(BR.item)
            .addType<IHebrewWordViewModel>(R.layout.item_hebrew)

        list.layoutManager = LinearLayoutManager(activity)
        list.adapter = adapter

        viewModel.onCreate.observe(this) {
            fragmentNavigation.get().openCreate()
        }

        viewModel.wordsList.observe(this) {
            adapter.set(it.map(::toViewModel))
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.update()
    }

    private fun toViewModel(item: WordItem): Any =
        when (item) {
            is WordItem.Hebrew -> HebrewWordViewModel(item)
        }

}