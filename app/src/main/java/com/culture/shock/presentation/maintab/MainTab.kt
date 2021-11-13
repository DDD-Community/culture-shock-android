package com.culture.shock.presentation.maintab

import androidx.viewpager2.widget.ViewPager2
import com.culture.shock.R
import com.culture.shock.base.ui.BaseFragment
import com.culture.shock.databinding.FragmentMainTabBinding
import com.culture.shock.presentation.maintab.adapter.MainFragmentAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainTab : BaseFragment<FragmentMainTabBinding>(
    FragmentMainTabBinding::inflate
) {
    private val fragmentAdapter by lazy {
        MainFragmentAdapter(this)
    }

    override fun initView() = binding {
        viewpager.adapter = fragmentAdapter
        viewpager.isUserInputEnabled = false
        viewpager.registerOnPageChangeCallback(
            object : ViewPager2.OnPageChangeCallback() {
                override fun onPageSelected(position: Int) {
                    bottomNav.menu.getItem(position).isChecked = true
                }
            }
        )

        bottomNav.setOnItemSelectedListener {
            val position = when (it.itemId) {
                R.id.home -> 0
                R.id.performance -> 1
                R.id.myInfo -> 2
                else -> 0
            }
            viewpager.setCurrentItem(position, false)
            true
        }
    }
}
