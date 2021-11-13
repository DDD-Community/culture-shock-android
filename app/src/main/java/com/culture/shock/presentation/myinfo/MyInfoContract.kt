package com.culture.shock.presentation.myinfo

import com.culture.shock.base.mvi.ViewEffect
import com.culture.shock.base.mvi.ViewIntent
import com.culture.shock.base.mvi.ViewState

sealed interface MyInfoIntent : ViewIntent

object MyInfoState : ViewState

sealed interface MyInfoEffect : ViewEffect
