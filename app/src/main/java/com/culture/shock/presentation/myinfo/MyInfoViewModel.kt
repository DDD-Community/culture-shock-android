package com.culture.shock.presentation.myinfo

import com.culture.shock.base.mvi.MVIVIewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyInfoViewModel  @Inject constructor() : MVIVIewModel<MyInfoIntent, MyInfoState, MyInfoEffect>() {
    override fun createInitialState(): MyInfoState = MyInfoState

    override fun processIntent(intent: MyInfoIntent) {

    }

}