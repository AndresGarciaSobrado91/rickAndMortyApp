package com.example.rickandmortyapp.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.rickandmortyapp.databinding.FragmentDetailBinding
import com.example.rickandmortyapp.ui.MainViewModel
import com.example.rickandmortyapp.ui.base.BaseDaggerFragment
import javax.inject.Inject

class DetailFragment : BaseDaggerFragment() {

    lateinit var binding : FragmentDetailBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(requireActivity(),viewModelFactory).get(MainViewModel::class.java)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let { args ->
            var args = DetailFragmentArgs.fromBundle(args)
            loadData(args.characterIndex)
        }
    }

    private fun loadData(characterIndex: Int) {

        val character = viewModel.characterList[characterIndex]

        character?.let {
            Glide
                .with(this)
                .load(it.image)
                .centerCrop()
                .into(binding.image)

            with(binding){
                textViewTitle.text = it.name
                textViewStatusDetail.text = it.status
                textViewSpecieDetail.text = it.species
                textViewGenderDetail.text = it.gender
            }
        }

    }
}