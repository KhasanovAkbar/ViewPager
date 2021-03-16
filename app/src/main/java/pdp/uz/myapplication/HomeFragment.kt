package pdp.uz.myapplication

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_home.view.*
import kotlinx.android.synthetic.main.tab_layout.view.*
import pdp.uz.myapplication.adapters.CategoryAdapter
import java.lang.reflect.Type


class HomeFragment : Fragment() {

    lateinit var root: View
    private var gson = Gson()
    lateinit var category: ArrayList<Category>
    lateinit var categoryAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_home, container, false)
        MySharedPreference.init(container!!.context)

        val info = MySharedPreference.info
        val type: Type = object : TypeToken<ArrayList<Category>>() {}.type
        category = gson.fromJson(info, type)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        categoryAdapter = CategoryAdapter(category, childFragmentManager)
        root.view_pager.adapter = categoryAdapter
        root.tab_layout.setupWithViewPager(root.view_pager)

        setTabs()

        tab_layout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.indicator_layout?.visibility = View.VISIBLE
                customView?.title_tv!!.setTextColor(Color.WHITE)
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                val customView = tab?.customView
                customView?.indicator_layout!!.visibility = View.INVISIBLE
                customView.title_tv!!.setTextColor(Color.GRAY)

            }

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

        })

    }

    private fun setTabs() {
        val tabCount = root.tab_layout.tabCount

        for (i in 0 until tabCount) {
            val tabView = LayoutInflater.from(context).inflate(R.layout.tab_layout, null, false)
            val tabAt = root.tab_layout.getTabAt(i)
            tabAt?.customView = tabView

            tabView.title_tv.text = category[i].title
            if (i == 0) {
                tabView.indicator_layout.visibility = View.VISIBLE
                tabView.title_tv.setTextColor(Color.WHITE)
            } else {
                tabView.indicator_layout.visibility = View.INVISIBLE
            }

        }
    }


}