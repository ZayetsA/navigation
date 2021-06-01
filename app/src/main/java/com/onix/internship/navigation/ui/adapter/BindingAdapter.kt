package com.onix.internship.navigation.ui.adapter

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("setTextViewText")
fun TextView.setTextViewText(score: Int) {
    text = "You score is: $score"
}