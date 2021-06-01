package com.onix.internship.navigation.ui.exit

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.onix.internship.navigation.R

class ExitDialogFragment : Fragment() {

    companion object {
        fun newInstance() = ExitDialogFragment()
    }

    private lateinit var viewModel: ExitDialogViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.exit_dialog_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ExitDialogViewModel::class.java)
        // TODO: Use the ViewModel
    }

}