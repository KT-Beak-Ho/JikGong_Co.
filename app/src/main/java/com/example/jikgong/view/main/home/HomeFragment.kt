package com.example.jikgong.view.main.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager.widget.ViewPager
import com.example.jikgong.R
import com.example.jikgong.databinding.FragmentHomeBinding
import com.example.jikgong.view.main.scout.HomeCompleteFragment
import com.example.jikgong.view.main.scout.HomeOnGoingFragment
import com.example.jikgong.view.main.scout.HomeScheduleFragment
import com.example.jikgong.view.main.scout.ScoutListFragment
import com.example.jikgong.view.main.scout.ScoutSuggestionListFragment
import com.google.android.material.tabs.TabLayout

class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    // This property is only valid between onCreateView and
    // onDestroyView.

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {}
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // 알림 테스트 용, intent 또는 fragment로 교체 예정
        binding.buttonNotification.setOnClickListener {
            var builder = AlertDialog.Builder(this.activity)
            builder.setTitle("알림")
            builder.setMessage("알림입니다요오")

            builder.setNegativeButton("취소") {dialog, which ->
                dialog.dismiss()
            }
            val dialog = builder.create()
            dialog.show()
        }

        val tabLayout: TabLayout = root.findViewById(R.id.homeTapLayout)
        val viewPager: ViewPager = root.findViewById(R.id.homeViewPager)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)

        return root
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(HomeOnGoingFragment(), "진행중")
        adapter.addFragment(HomeScheduleFragment(), "예정")
        adapter.addFragment(HomeCompleteFragment(), "완료")
        viewPager.adapter = adapter
    }

    private class ViewPagerAdapter(manager: androidx.fragment.app.FragmentManager) :
        androidx.fragment.app.FragmentPagerAdapter(manager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
        private val fragments: MutableList<Fragment> = ArrayList()
        private val titles: MutableList<String> = ArrayList()

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titles[position]
        }

        fun addFragment(fragment: Fragment, title: String) {
            fragments.add(fragment)
            titles.add(title)
        }
    }
}