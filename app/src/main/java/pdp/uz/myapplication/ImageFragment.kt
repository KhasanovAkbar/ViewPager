package pdp.uz.myapplication

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.fragment_image.view.*
import pdp.uz.myapplication.adapters.RvAdapter


private const val ARG_PARAM1 = "param1"


class ImageFragment : Fragment() {

    private var param1: ArrayList<Int>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getIntegerArrayList(ARG_PARAM1)
        }
    }

    lateinit var rvAdapter: RvAdapter
    lateinit var root: View
    var bundle = Bundle()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        root = inflater.inflate(R.layout.fragment_image, container, false)
        rvAdapter = RvAdapter(param1!!, object : RvAdapter.OnMyItemClickListener {
            override fun onItemClick(image: Int) {
                bundle.putInt("img", image)
                findNavController().navigate(R.id.secondFragment, bundle)
            }

        })
        root.rv.adapter = rvAdapter
        return root
    }

    companion object {

        @JvmStatic
        fun newInstance(param1: ArrayList<Int>) =
            ImageFragment().apply {
                arguments = Bundle().apply {
                    putIntegerArrayList(ARG_PARAM1, param1)
                }
            }
    }
}