package pdp.uz.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.google.gson.Gson

class MainActivity : AppCompatActivity() {
    private var gson = Gson()
    lateinit var listCategory: ArrayList<Category>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MySharedPreference.init(this)
        loadData()
    }

    private fun loadData() {
        if (MySharedPreference.info == "") {
            var imageList = arrayListOf(
                R.drawable.new1,
                R.drawable.new2,
                R.drawable.new3,
                R.drawable.new4,
                R.drawable.new5,
                R.drawable.new6,
                R.drawable.new7,
                R.drawable.new8,
                R.drawable.new9,

                R.drawable.nature1,
                R.drawable.nature2,
                R.drawable.nature3,
                R.drawable.nature4,
                R.drawable.nature5,
                R.drawable.nature6,
                R.drawable.nature7,
                R.drawable.nature8,
                R.drawable.nature9,

                R.drawable.kengiru,
                R.drawable.monkey,
                R.drawable.pingving,
                R.drawable.qarga,
                R.drawable.qoplon,
                R.drawable.quloq,
                R.drawable.rabbit,
                R.drawable.ara,
                R.drawable.new9,
                R.drawable.techno1,
                R.drawable.techno2,
                R.drawable.techno3,
                R.drawable.techno4,
                R.drawable.techno5,
                R.drawable.techno6,
                R.drawable.techno7,
                R.drawable.techno8,
                R.drawable.techno9
            )

            imageList.shuffle()
            var imageList1 = arrayListOf(
                R.drawable.new1,
                R.drawable.new2,
                R.drawable.new3,
                R.drawable.new4,
                R.drawable.new5,
                R.drawable.new6,
                R.drawable.new7,
                R.drawable.new8,
                R.drawable.new9,
                R.drawable.new1,
                R.drawable.new2,
                R.drawable.new3,
                R.drawable.new4,
                R.drawable.new5,
                R.drawable.new6,
                R.drawable.new7,
                R.drawable.new8,
                R.drawable.new9

            )
            imageList1.shuffle()
            var imageList2 = arrayListOf(
                R.drawable.kengiru,
                R.drawable.monkey,
                R.drawable.pingving,
                R.drawable.qarga,
                R.drawable.qoplon,
                R.drawable.quloq,
                R.drawable.rabbit,
                R.drawable.ara,
                R.drawable.kengiru,
                R.drawable.monkey,
                R.drawable.pingving,
                R.drawable.qarga,
                R.drawable.qoplon,
                R.drawable.quloq,
                R.drawable.rabbit,
                R.drawable.ara,
            )
            imageList2.shuffle()
            var imageList3 = arrayListOf(
                R.drawable.techno1,
                R.drawable.techno2,
                R.drawable.techno3,
                R.drawable.techno4,
                R.drawable.techno5,
                R.drawable.techno6,
                R.drawable.techno7,
                R.drawable.techno8,
                R.drawable.techno9,
                R.drawable.techno1,
                R.drawable.techno2,
                R.drawable.techno3,
                R.drawable.techno4,
                R.drawable.techno5,
                R.drawable.techno6,
                R.drawable.techno7,
                R.drawable.techno8,
                R.drawable.techno9
            )
            imageList3.shuffle()
            var imageList4 = arrayListOf(
                R.drawable.nature1,
                R.drawable.nature2,
                R.drawable.nature3,
                R.drawable.nature4,
                R.drawable.nature5,
                R.drawable.nature6,
                R.drawable.nature7,
                R.drawable.nature8,
                R.drawable.nature9,
                R.drawable.nature1,
                R.drawable.nature2,
                R.drawable.nature3,
                R.drawable.nature4,
                R.drawable.nature5,
                R.drawable.nature6,
                R.drawable.nature7,
                R.drawable.nature8,
                R.drawable.nature9
            )
            imageList4.shuffle()

            listCategory = ArrayList()
            listCategory.add(Category("All", imageList))
            listCategory.add(Category("New", imageList1))
            listCategory.add(Category("Animals", imageList2))
            listCategory.add(Category("Technology", imageList3))
            listCategory.add(Category("Nature", imageList4))

            val toJson = gson.toJson(listCategory)
            MySharedPreference.info = toJson
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return Navigation.findNavController(this, R.id.my_nav_host_fragment).navigateUp()

    }


}