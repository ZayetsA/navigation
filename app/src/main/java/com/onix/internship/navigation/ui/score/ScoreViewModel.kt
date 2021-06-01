package com.onix.internship.navigation.ui.score

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.onix.internship.navigation.events.SingleLiveEvent

class ScoreViewModel(_model: ScoreModel, count: Int) : ViewModel() {
    val model = _model

    private val _navigationEvent = SingleLiveEvent<NavDirections>()
    val navigationEvent: LiveData<NavDirections> = _navigationEvent

    private val _countCurrentFragment = MutableLiveData(count)
    val countCurrentFragment: LiveData<Int> = _countCurrentFragment

    private fun getCount() = _countCurrentFragment.value!!

    fun toNextFragment() {
        _navigationEvent.postValue(
            ScoreFragmentDirections.actionScoreFragmentSelf(
                model.apply { score++ },
                false,
                getCount() + 1
            )
        )
    }

    fun toPreviousFragment() {
        if (model.score > 0) {
            _navigationEvent.value =
                ScoreFragmentDirections.actionScoreFragmentSelf(
                    model,
                    true,
                    getCount()
                )
            return
        }
        _navigationEvent.value = ScoreFragmentDirections.actionScoreFragmentToExitDialogFragment()
    }

    fun toStart() {
        _navigationEvent.postValue(ScoreFragmentDirections.actionScoreFragmentStart(model.apply {
            score = 0
        }))
    }
}