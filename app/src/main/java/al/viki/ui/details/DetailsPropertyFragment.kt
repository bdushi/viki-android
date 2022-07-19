package al.viki.ui.details

import al.viki.databinding.FragmentDetailsPropertyBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsPropertyFragment : Fragment() {
//    private val args: DetailsPropertyFragmentArgs by navArgs()
    private var _binding: FragmentDetailsPropertyBinding? = null
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentDetailsPropertyBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.topAppBar?.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
//        binding?.property = args.property
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}