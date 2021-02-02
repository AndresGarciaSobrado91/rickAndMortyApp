package com.example.rickandmortyapp.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.R
import com.example.rickandmortyapp.databinding.FragmentHomeBinding
import com.example.rickandmortyapp.domain.GetCharactersUseCaseResult
import com.example.rickandmortyapp.ui.MainViewModel
import com.example.rickandmortyapp.ui.base.BaseDaggerFragment
import com.example.rickandmortyapp.util.ui.LoadingViewManager
import javax.inject.Inject

class HomeFragment : BaseDaggerFragment() {

    lateinit var binding : FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainViewModel

    private val getCharactersObserver = Observer<GetCharactersUseCaseResult> { result ->
        when (result){
            is GetCharactersUseCaseResult.Loading -> showLoading(getString(R.string.loading))
            is GetCharactersUseCaseResult.Result -> {
                hideLoading()
                if (result != null){
                    viewModel.setCharacterList(result.characterList)
                    loadData()
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(requireActivity(),viewModelFactory).get(MainViewModel::class.java)
        with(viewModel){
            registerObserver(viewLifecycleOwner,charactersResult,getCharactersObserver)
        }
        return binding.root
    }

    private fun loadData() {
        Glide
            .with(this)
            .load(viewModel.characterList.first().image)
            .centerCrop()
            .into(binding.image1)

        Glide
            .with(this)
            .load(viewModel.characterList.last().image)
            .centerCrop()
            .into(binding.image2)

        setListeners()
    }

    private fun setListeners() {
        with(binding){
            cardView1.setOnClickListener { view ->
                view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(0))
            }
            cardView2.setOnClickListener { view ->
                view.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToDetailFragment(1))
            }
        }
    }

    override fun onDestroyView() {
        viewModel.removeObservers(viewLifecycleOwner)
        super.onDestroyView()
    }
}