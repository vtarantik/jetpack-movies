package com.tarantik.test.base

import com.tarantik.core.base.arch.BaseViewModel
import com.tarantik.core.test.MainDispatcherRule
import org.junit.Before
import org.junit.Rule

@SuppressWarnings("VariableNaming")
open class BaseViewModelTest<T : BaseViewModel> {

    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    @Before
    open fun mock() {
    }
}
