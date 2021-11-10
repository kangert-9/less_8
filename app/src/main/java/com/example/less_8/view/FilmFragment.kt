package com.example.less_8.view

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.less_8.databinding.FragmentFilmBinding
import com.example.less_8.model.Film
import com.example.less_8.model.FilmDTO
import com.example.less_8.model.FilmLoader

class FilmFragment : Fragment() {
    private var _binding: FragmentFilmBinding? = null
    private val binding get() = _binding!!
    private lateinit var filmBundle: Film
    private val onLoadListener: FilmLoader.FilmLoaderListener =
        object : FilmLoader.FilmLoaderListener {

            override fun onLoaded(filmDTO: FilmDTO) {
                displayFilm(filmDTO)
            }
            override fun onFailed(throwable: Throwable) {
                Log.e("", "Fail URI", throwable)
                throwable.printStackTrace()
            }
        }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFilmBinding.inflate(inflater, container, false)
        return binding.root
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        filmBundle = arguments?.getParcelable(BUNDLE_EXTRA) ?: Film(filmBundle.id,filmBundle.name, filmBundle.rating, filmBundle.director, filmBundle.year, filmBundle.isLike)
        val loader = FilmLoader (onLoadListener, filmBundle.id!!)
        loader.loadFilm()
    }

    private fun displayFilm (filmDTO: FilmDTO) {
        binding.nameFilm.text = filmDTO.original_title.toString()
        binding.descriptionFilm.text = filmDTO.overview.toString()
    }

    companion object {
        const val BUNDLE_EXTRA = "film"
        fun newInstance(bundle: Bundle): FilmFragment {
            val fragment = FilmFragment()
            fragment.arguments = bundle
            return fragment
        }
    }
}