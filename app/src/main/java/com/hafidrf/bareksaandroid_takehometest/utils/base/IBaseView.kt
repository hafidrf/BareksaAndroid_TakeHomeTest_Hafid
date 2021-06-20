package com.hafidrf.bareksaandroid_takehometest.utils.base

import androidx.annotation.LayoutRes

/**
 * Created on 11/27/20.
 */
interface IBaseView {
    @LayoutRes
    fun getLayoutResource(): Int
    fun initViews()
    fun initObservers()
    fun initData()

}