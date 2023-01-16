package al.viki.ui.viki

import al.viki.R
import al.viki.databinding.FragmentVikiBinding
import al.viki.model.FilterUi
import al.viki.model.UserUi
import al.viki.ui.home.HomeViewModel
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels

class VikiFragment : Fragment(R.layout.fragment_viki) {
    private var userUi: UserUi? = null
    private var filterUi = FilterUi()
    private var properties = true
    private var _binding: FragmentVikiBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding

    private val homeViewModel: HomeViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVikiBinding.bind(view)
    }
}