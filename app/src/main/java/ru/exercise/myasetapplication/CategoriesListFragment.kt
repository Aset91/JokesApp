package ru.exercise.myasetapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import ru.exercise.myasetapplication.databinding.FragmentCategoriesListBinding

class CategoriesListFragment : Fragment() {
    private lateinit var binding: FragmentCategoriesListBinding
    private val viewModel: CategoriesListViewModel by viewModels()
    private val categoriesAdapter = CategoriesAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategoriesListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        viewModel.jokes.observe(viewLifecycleOwner) {
            categoriesAdapter.submitList(it)
        }
    }

    private fun initRecyclerView() {
        binding.rvJokes.adapter = categoriesAdapter
    }
}