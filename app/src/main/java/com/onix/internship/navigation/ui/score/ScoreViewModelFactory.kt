package com.onix.internship.navigation.ui.score

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

@Suppress("UNCHECKED_CAST")
class ScoreViewModelFactory(private var model: ScoreModel, private var count: Int) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ScoreViewModel::class.java)) {
            return ScoreViewModel(model, count) as T
        }
        throw IllegalArgumentException("Unknown view model class!")
    }
}