package com.ir.appsplashscreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.tabs.TabLayoutMediator
import com.ir.appsplashscreen.AdapterPager.AdapterPager
import com.ir.appsplashscreen.DataClassPager.DataClassPager
import com.ir.appsplashscreen.databinding.FragmentSplashBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class SplashFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    lateinit var binding: FragmentSplashBinding
    lateinit var arrayListPager: ArrayList<DataClassPager>
    lateinit var adapterPager: AdapterPager
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        arrayListPager = ArrayList()
        binding = FragmentSplashBinding.inflate(layoutInflater)
        arrayListPager.add(DataClassPager("Xush kelipsiz",
            "Kim bo'rubdur, ey ko'ngil, ahli jahondin yaxshilig', \n Kimki, ondin yaxshi yo'q , ko'z tutma ondin yaxshilig'.",
            R.drawable.bitmap_1))
        arrayListPager.add(DataClassPager("Hikoyalar dunyosi",
            "Gar zamonni nayf qilsam ayb qilma, ey rafiq,\n Ko‘rmadim hargiz, netoyin, bu zamondin yaxshilig‘!",
            R.drawable.bitmap_2))
        arrayListPager.add(DataClassPager("Kitob ortidan...",
            "Dilrabolardin yomonliq keldi mahzun ko‘ngluma,\n Kelmadi jonimg'a hech oromi jondin yaxshilig'.",
            R.drawable.bitmap_3))
        arrayListPager.add(DataClassPager("Bizga qo'shiling",
            "Ey ko‘ngul, chun yaxshidin ko‘rdung yamonliq asru ko‘p,\n Emdi ko‘z tutmoq ne ma’ni har yamondin yaxshilig'?",
            R.drawable.bitmap_4))
        adapterPager = AdapterPager(requireActivity(), arrayListPager, requireActivity())

        binding.viewPager.adapter = adapterPager

        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
        }.attach()


        return binding.root
    }

    companion object {
        fun newInstance(param1: String, param2: String) =
            SplashFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}