package al.viki.ui.account

import al.bruno.adapter.DropDownAdapter
import al.bruno.core.State
import al.viki.R
import al.viki.common.collectFlow
import al.viki.databinding.DropDownItemBinding
import al.viki.databinding.FragmentRequestNewAccountBinding
import al.viki.databinding.FragmentSettingsBinding
import al.viki.model.AuthorityUi
import al.viki.model.CityUi
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RequestNewAccountFragment: Fragment() {
    private val requestNewAccountViewModel: RequestNewAccountViewModel by viewModels()

    private var _binding: FragmentRequestNewAccountBinding? = null
    private val binding get() = _binding
    private val authorityAdapter =
        DropDownAdapter<AuthorityUi, DropDownItemBinding>(R.layout.drop_down_item) { t, vm ->
            vm.selection = t
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRequestNewAccountBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.lifecycleOwner = this
        _binding?.requestNewAccountViewModel = requestNewAccountViewModel
        _binding?.adapter = authorityAdapter
        collectFlow(requestNewAccountViewModel.authorities) {
            when (it) {
                is State.Success -> {
                    it.t?.let { cities ->
                        authorityAdapter.setItem(cities)
                    }
                }
                is State.Error -> {}
                is State.Unauthorized -> {
                    binding?.let { root ->
                        Snackbar.make(root.root, "Unauthorized", Snackbar.LENGTH_SHORT).show()
                    }
                }
                is State.Loading -> {}
            }
        }

        collectFlow(requestNewAccountViewModel.request) {
            when(it) {
                is State.Error -> {

                }
                is State.Loading -> {

                }
                is State.Success -> {
                    if(it.t == true) {
                        findNavController().popBackStack()
                    }
                }
                is State.Unauthorized -> {

                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}