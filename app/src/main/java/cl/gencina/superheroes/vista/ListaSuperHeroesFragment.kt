package cl.gencina.superheroes.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.gencina.superheroes.R
import cl.gencina.superheroes.databinding.FragmentListaSuperHeroesBinding

class ListaSuperHeroesFragment : Fragment() {
    lateinit var binding : FragmentListaSuperHeroesBinding
    private val viewmodel: SuperHeroeViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListaSuperHeroesBinding.inflate(layoutInflater, container, false)
        viewmodel.getData()
        initAdapter()
        return binding.root
    }

    private fun initAdapter() {
        val  adapter = AdapterListaSuperHeroes()
        binding.rvSuperHeroes.adapter = adapter

        viewmodel.listaSuperHeroesLiveData().observe(viewLifecycleOwner) {
            adapter.setData(it)
        }
    }


}