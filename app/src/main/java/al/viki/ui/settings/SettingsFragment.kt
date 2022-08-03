package al.viki.ui.settings

import al.viki.R
import al.viki.databinding.FragmentSettingsBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment: Fragment() {
    private var _binding: FragmentSettingsBinding? = null
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSettingsBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding?.settingsRequestNewAccount?.setOnClickListener {
            findNavController().navigate(R.id.action_settingsFragment_to_requestNewAccountFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}