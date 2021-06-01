package com.onix.internship.navigation.ui.score

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ScoreModel(var score: Int = 0) : Parcelable {
}