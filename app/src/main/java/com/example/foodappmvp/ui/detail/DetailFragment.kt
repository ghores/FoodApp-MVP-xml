package com.example.foodappmvp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.foodappmvp.data.model.home.ResponseFoodList
import com.example.foodappmvp.data.repository.DetailPresenter
import com.example.foodappmvp.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DetailFragment : Fragment(), DetailContracts.View {
    //Binding
    private lateinit var binding: FragmentDetailBinding

    @Inject
    lateinit var presenter: DetailPresenter

    //Other
    private val args: DetailFragmentArgs by navArgs()
    private var foodId = 0

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //InitView
        binding.apply {
            //Get food id
            foodId = args.foodId
            if (foodId > 0) {
                //Call api
                presenter.callFoodDetails(foodId)
            }
        }
    }

    override fun loadFoodDetails(data: ResponseFoodList) {
        TODO("Not yet implemented")
    }

    override fun showLoading() {
        TODO("Not yet implemented")
    }

    override fun hideLoading() {
        TODO("Not yet implemented")
    }

    override fun checkInternet(): Boolean {
        TODO("Not yet implemented")
    }

    override fun internetError(hasInternet: Boolean) {
        TODO("Not yet implemented")
    }

    override fun serverError(message: String) {
        TODO("Not yet implemented")
    }
}