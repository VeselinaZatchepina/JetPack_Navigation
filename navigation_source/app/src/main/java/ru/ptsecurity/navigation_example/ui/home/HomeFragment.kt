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

        binding.writeDataBtn.setOnClickListener {
            val args = Bundle()
            args.putString("data", "https://mobile-stingray.ru/")

            findNavController().navigate(
                R.id.navigation_write_to_file,
                args
            )
        }

        binding.saveToDbBtn.setOnClickListener {
            val args = Bundle()
            args.putString("name", "Johnny")
            args.putString("surname", "Blaze")

            findNavController().navigate(
                R.id.navigation_save_to_db,
                args
            )
        }

        binding.intentWithUrlBtn.setOnClickListener {
            val args = Bundle()
            args.putString("url", "https://gratisography.com/wp-content/uploads/2023/01/gratisography-frog-racer-free-stock-photo-1165x780.jpg")

            findNavController().navigate(
                R.id.navigation_intent_with_url,
                args
            )
        }

        binding.showInfoBtn.setOnClickListener {
            val args = Bundle()
            args.putString("info", "My Info")

            findNavController().navigate(
                R.id.navigation_show_info,
                args
            )
        }

        binding.showInnerBtn.setOnClickListener {
            val args = Bundle()
            args.putString("info", "My Inner Info")

            findNavController().navigate(
                R.id.toInner,
                args
            )
        }
    }
}