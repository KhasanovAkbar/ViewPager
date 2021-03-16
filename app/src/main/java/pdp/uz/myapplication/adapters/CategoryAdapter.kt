package pdp.uz.myapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import pdp.uz.myapplication.Category
import pdp.uz.myapplication.ImageFragment

class CategoryAdapter(var categoryList: ArrayList<Category>, fragmentManager: FragmentManager) :
    FragmentStatePagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {
    override fun getCount(): Int {
        return categoryList.size
    }

    override fun getItem(position: Int): Fragment {
        return ImageFragment.newInstance(categoryList[position].imageList)
    }
}