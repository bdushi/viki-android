package al.viki.ui.settings

import al.viki.BuildConfig
import al.viki.databinding.FragmentSettingsBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment: Fragment() {

    private val args: SettingsFragmentArgs by navArgs()
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
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
        binding?.settingsRequestNewAccount?.setOnClickListener {
           findNavController().navigate(SettingsFragmentDirections.actionSettingsFragmentToRequestNewAccountFragment())
        }
        binding?.settingsRequestNewAccount?.visibility = if(args.user?.authorities?.find { it == 10000.toLong() } == 10000.toLong()) View.VISIBLE else View.GONE
        binding?.tvSettingsAppVersion?.text = BuildConfig.VERSION_NAME
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}