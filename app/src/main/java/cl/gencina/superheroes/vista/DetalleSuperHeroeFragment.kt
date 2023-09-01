package cl.gencina.superheroes.vista

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import cl.gencina.superheroes.R
import cl.gencina.superheroes.data.local.SuperHeroeEntity
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
                binding.fabCorreo.setOnClickListener {_ ->
                    enviarCorreo(it)
                }
            }
        }
    }

    private fun enviarCorreo(superHeroeEntity: SuperHeroeEntity) {
        val email = getString(R.string.direccion_email)
        val emailIntent = Intent(Intent.ACTION_SEND, Uri.parse(email))
        emailIntent.type = getString(R.string.text_plain)
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.titulo_email,
            superHeroeEntity.nombre)  )
        emailIntent.putExtra(
            Intent.EXTRA_TEXT, getString(
            R.string.cuerpo_email,
                superHeroeEntity.nombre
        ))
        emailIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
        try {
            startActivity(Intent.createChooser(emailIntent, getString(R.string.enviar_email)))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                context,
                getString(R.string.no_existe__cliente_de_email_instalado),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}