package ru.ptsecurity.navigation_example.ui.webview

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.ptsecurity.navigation_example.R
import ru.ptsecurity.navigation_example.databinding.FragmentWebviewBinding


open class WebViewFragment : Fragment(R.layout.fragment_webview) {

    protected val binding by viewBinding(FragmentWebviewBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(binding) {
            wv.run {
                settings.javaScriptEnabled = true
                settings.loadWithOverviewMode = true
                settings.useWideViewPort = true
                settings.allowFileAccess = true

                val safeArgs: WebViewFragmentArgs by navArgs()
                if (safeArgs.url.isNotEmpty()) {
                    loadUrl(safeArgs.url)
                }
            }
        }
    }
}