package com.onix.internship.navigation.ui.score

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.onix.internship.navigation.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private val args: ScoreFragmentArgs by navArgs()
    private val viewModel: ScoreViewModel by viewModels {
        ScoreViewModelFactory(args.model, args.count)
    }
    private lateinit var binding: FragmentScoreBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentScoreBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        viewModel.navigationEvent.observe(viewLifecycleOwner, ::navigate)
        Log.d("FROM FRAGMENT", args.model.toString())
        Log.d("FROM FRAGMENT", args.count.toString())
//        handleBackButton()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        val callback: OnBackPressedCallback = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                navigate(ScoreFragmentDirections.actionScoreFragmentToExitDialogFragment())
            }
        }
        if (viewModel.model.score == 0) {
            requireActivity().onBackPressedDispatcher.addCallback(this, callback)
        }
    }

    private fun navigate(direction: NavDirections) {
        if (direction.arguments.get("isBack") == true) {
            requireActivity().onBackPressed()
            return
        }
        findNavController().navigate(direction)
    }

//    private fun handleBackButton() {
//        requireActivity()
//            .onBackPressedDispatcher
//            .addCallback(viewLifecycleOwner, object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    activity?.finish()
//                }
//            })
//    }
}