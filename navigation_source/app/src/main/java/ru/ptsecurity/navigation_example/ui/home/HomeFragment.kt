package ru.ptsecurity.navigation_example.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentHomeBinding
import ru.ptsecurity.navigation_example.databinding.FragmentPasscodeBinding

class HomeFragment : Fragment() {

    protected val binding by viewBinding(FragmentHomeBinding::bind)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.openWvBtn.setOnClickListener {
            val args = Bundle()
            args.putString("url", "https://mobile-stingray.ru/")

            findNavController().navigate(
                R.id.navigation_webview,
                args
            )
        }
    }
}