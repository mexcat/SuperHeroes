package cl.gencina.superheroes.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import cl.gencina.superheroes.R
import cl.gencina.superheroes.databinding.FragmentDetalleSuperHeroeBinding
import coil.load

class DetalleSuperHeroeFragment : Fragment() {
    private var id: Int = 0
    lateinit var binding : FragmentDetalleSuperHeroeBinding
    private val viewModel: SuperHeroeViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            id = it.getInt("id")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetalleSuperHeroeBinding.inflate(layoutInflater, container, false)
        viewModel.getDetalle(id)
        cargarDetalle(id)
        return binding.root
    }

    private fun cargarDetalle(id: Int) {
        viewModel.superHeroeLiveData(id).observe(viewLifecycleOwner){
            if(it!= null){
                binding.ivDetalle.load(it.imagenLink)
                binding.tvNombreDetalle.text = it.nombre
                binding.tvOrigenDetalle.text = it.origen
                binding.tvPoderDetalle.text = it.poder
                binding.tvAnioCreacionDetalle.text = it.anioCreacion.toString()
                binding.tvColorDetalle.text = it.color
                binding.tvTraduccion.text =
                    if(it.traduccion == true){
                        getString(R.string.traduccion_si)
                    }else{
                        getString(R.string.traduccion_no)
                    }
            }
        }
    }
}