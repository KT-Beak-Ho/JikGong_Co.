package com.example.jikgong.view.main.scout

import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import androidx.appcompat.widget.Toolbar
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.example.jikgong.R
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class ScoutFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_scout, container, false)

        // Toolbar 설정
        val toolbar: Toolbar = view.findViewById(R.id.toolbar)
        toolbar.inflateMenu(R.menu.scout_toolbar)

        // 메뉴 아이템 클릭 이벤트 처리 (선택사항)
        toolbar.setOnMenuItemClickListener { item ->
            when (item.itemId) {
                R.id.menu_item_list -> {
                    // "ic_list.png" 아이콘 버튼 클릭 시 처리할 내용 추가
                    true
                }

                else -> false
            }
        }
        // TabLayout 및 ViewPager 설정
        val tabLayout: TabLayout = view.findViewById(R.id.tabLayout)
        val viewPager: ViewPager = view.findViewById(R.id.viewPager)
        setupViewPager(viewPager)
        tabLayout.setupWithViewPager(viewPager)

        return view
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = ViewPagerAdapter(childFragmentManager)
        adapter.addFragment(ScoutListFragment(), "인력 목록")
        adapter.addFragment(ScoutSuggestionListFragment(), "제안 목록")
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