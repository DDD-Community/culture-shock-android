package com.culture.shock.presentation.maintab

import com.culture.shock.R
import com.culture.shock.base.ui.BaseFragment
import com.culture.shock.databinding.FragmentMainTabBinding
import com.culture.shock.util.BackButtonBehaviour
import com.culture.shock.util.setupWithNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainTab : BaseFragment<FragmentMainTabBinding>(
    FragmentMainTabBinding::inflate
) {
    private var bottomNavSelectedItemId = R.id.home
    private val navGraphIds by lazy {
        listOf(R.navigation.nav_home, R.navigation.nav_performance, R.navigation.nav_my_info)
    }

    override fun initView() = binding {
        bottomNav.selectedItemId = bottomNavSelectedItemId
        val controller = bottomNav.setupWithNavController(
            fragmentManager = childFragmentManager,
            navGraphIds = navGraphIds,
            backButtonBehaviour = BackButtonBehaviour.POP_HOST_FRAGMENT,
            containerId = R.id.bottom_nav_container,
            firstItemId = R.id.home,
            intent = requireActivity().intent
        )
        controller.observe(viewLifecycleOwner, { navController ->
            bottomNavSelectedItemId =
                navController.graph.id // Needed to maintain correct state on return
        })
    }
}
