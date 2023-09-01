package cl.gencina.superheroes.vista

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import cl.gencina.superheroes.R
import cl.gencina.superheroes.data.local.SuperHeroeEntity
import cl.gencina.superheroes.databinding.ItemListaBinding
import coil.load

class AdapterListaSuperHeroes: RecyclerView.Adapter<AdapterListaSuperHeroes.ListaSuperHeroesViewHolder>() {
    lateinit var binding : ItemListaBinding

    private val listaSuperHeroes = mutableListOf<SuperHeroeEntity>()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListaSuperHeroesViewHolder {
        binding = ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListaSuperHeroesViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ListaSuperHeroesViewHolder,
        position: Int
    ) {
        val superHeroe = listaSuperHeroes[position]
        holder.bind(superHeroe)
    }

    override fun getItemCount(): Int {
        return listaSuperHeroes.size
    }

    fun setData(listaSuperHeroes: List<SuperHeroeEntity>){
        this.listaSuperHeroes.clear()
        this.listaSuperHeroes.addAll(listaSuperHeroes)
        notifyDataSetChanged()
    }
    class ListaSuperHeroesViewHolder(private val v: ItemListaBinding): RecyclerView.ViewHolder(v.root) {
        fun bind(superHeroe:SuperHeroeEntity){
            v.ivItem.load(superHeroe.imagenLink)
            v.tvModelo.text = superHeroe.nombre
            v.cvItem.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt("id", superHeroe.id)
                Navigation.findNavController(v.root).navigate(R.id.action_listaSuperHeroesFragment_to_detalleSuperHeroeFragment, bundle)

            }
        }
    }
}