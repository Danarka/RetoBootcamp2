package com.bcp.pokemonproject.ui.dashboard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.bcp.pokemonproject.R
import androidx.fragment.app.viewModels
import com.bcp.pokemonproject.data.entities.PokemonResponse
import com.bcp.pokemonproject.databinding.FragmentDashboardBinding
import com.bcp.pokemonproject.viewmodel.BCPViewModel

class DashboardFragment : Fragment(), View.OnClickListener {

    private val viewModelName: BCPViewModel by viewModels()
    lateinit var button : Button
    private lateinit var binding: FragmentDashboardBinding
    private lateinit var dashboardViewModel: DashboardViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        //setupViewModel()
        val binding = FragmentDashboardBinding.inflate(layoutInflater)
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_dashboard, container, false)
        dashboardViewModel.text.observe(viewLifecycleOwner, Observer {
        })

        return root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        button = getView()!!.findViewById(R.id.btnName)
        button.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.btnName->{
                viewModelName.doCharacterFetch("1")
            }
        }
    }

    private fun setupViewModel() {
        viewModelName.character.observe(this, characterObserver)
    }


    private val characterObserver = Observer<PokemonResponse> {
        binding.txtName.text = it.name
    }



}