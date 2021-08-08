package kr.ac.jetpack.showpeep

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kr.ac.jetpack.showpeep.databinding.FragmentCalendarBinding

class CalendarFragment : Fragment() {

    private var CalendarFragmentBinding : FragmentCalendarBinding? = null

    companion object {
        const val TAG : String = "로그"

        fun newInstance() : CalendarFragment {
            return CalendarFragment()
        }

    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "CalendarFragment - onCreate() called")
    }

    // 프레그먼트를 안고 있는 액티비티에 붙었을 때
    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d(TAG, "ProfileFragment - onAttach() called")
    }

    // 뷰가 생성되었을 때
    // 프레그먼트와 레이아웃을 연결시켜주는 부분이다.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "ProfileFragment - onCreateView() called")

        val view = inflater.inflate(R.layout.fragment_calendar, container, false)

        return view
//        return inflater.inflate(R.layout.fragment_calendar, container, false)
    }

}