package kr.ac.jetpack.showpeep

import kr.ac.jetpack.showpeep.databinding.FragmentHomeBinding
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class HomeFragment : Fragment() {

    //뷰가 사라질 때 같이 보내기 위해 따로 빼두기
    private var fragmentHomeBinding : FragmentHomeBinding? = null

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : HomeFragment {
            return HomeFragment()
        }

    }
    var count : Int = 0

    // 메모리에 올라갔을때
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "HomeFragment - onCreate() called")
    }

    // 프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "HomeFragment - onAttach() called")
    }

    // 뷰가 생성되었을 때
    // 프레그먼트와 레이아웃을 연결시켜주는 부분이다.
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {

        Log.d(TAG, "HomeFragment - onCreateView() called")

//        val view = inflater.inflate(R.layout.fragment_home, container, false)
//
//        return view

        //뷰 바인딩 가져오기
        // 홈 프레그먼트 -> 프레그먼트 홈 바인딩
        val binding = FragmentHomeBinding.inflate(inflater, container, false)
        fragmentHomeBinding = binding

        fragmentHomeBinding?.happyPeepBtn?.setOnClickListener{
            Log.d(TAG, "happy state btn 눌렸다.")
            count = count - 1

            fragmentHomeBinding?.hostImgView!!.src = "home $count"
        }

        return binding!!.root
    }

    //프레그먼트를 날릴 때 바인딩도 빈 값을 넣어서 날림
    override fun onDestroyView(){
        fragmentHomeBinding = null
        super.onDestroyView()
    }
}
