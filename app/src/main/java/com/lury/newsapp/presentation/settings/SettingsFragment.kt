package com.lury.newsapp.presentation.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.lury.newsapp.databinding.FragmentSettingsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingsFragment : Fragment() {
    private var _settingsBinding: FragmentSettingsBinding? = null
    private val settingsBinding get() = _settingsBinding!!

    private val settingsViewModel: SettingsViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _settingsBinding = FragmentSettingsBinding.inflate(
            layoutInflater, container, false
        )
        return settingsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        settingsViewModel.isDarkMode.observe(viewLifecycleOwner) { isChecked->
            settingsBinding.switchDarkMode.isChecked = isChecked

        }

        settingsBinding.switchDarkMode.setOnCheckedChangeListener{ _, isChecked ->
          if (isChecked) {
              settingsViewModel.saveSettings(true)
          }else {
              settingsViewModel.saveSettings(false)
          }
        }






    }
}
