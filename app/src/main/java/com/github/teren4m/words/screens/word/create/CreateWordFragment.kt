package com.github.teren4m.words.screens.word.create

import android.os.Bundle
import android.view.View
import androidx.databinding.ViewDataBinding
import com.github.teren4m.base.mvvm.MvvmFragment
import com.github.teren4m.base.observe
import com.github.teren4m.words.BR
import com.github.teren4m.words.IFragmentNavigation
import com.github.teren4m.words.R
import com.github.teren4m.words.screens.activity.main.IMainViewModel
import com.github.teren4m.words.screens.activity.main.modes.ModeType
import javax.inject.Inject

class CreateWordFragment : MvvmFragment<ICreateWordViewModel, ViewDataBinding>() {

    override val viewModelId = BR.viewModel

    override val layoutId = R.layout.fragment_create_word

    @Inject
    lateinit var fragmentNavigation: IFragmentNavigation

    @Inject
    lateinit var mainViewModel: IMainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.onBack.observe(this) {
            fragmentNavigation.back()
        }
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.startMode(ModeType.CREATE)
    }
}