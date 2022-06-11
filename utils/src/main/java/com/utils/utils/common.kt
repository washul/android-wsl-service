package com.utils.utils

import kotlin.contracts.ExperimentalContracts
import kotlin.contracts.contract


@ExperimentalContracts
fun CharSequence?.isNotNullOrEmpty(): Boolean {
    contract {
        returns(false) implies (this@isNotNullOrEmpty != null)
    }

    return this == null || this.isNotEmpty()
}