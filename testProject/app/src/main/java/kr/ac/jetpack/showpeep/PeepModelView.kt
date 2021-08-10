package kr.ac.jetpack.showpeep

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
enum class ActionType{
    HAPPY, SAD
}

class PeepModelView:ViewModel() {
    companion object{
        const val TAG: String ="로그"
    }
    private val _currentValue = MutableLiveData<String>()

    val currentValue: LiveData<String>
        get() = _currentValue

    init { // 초기값
        Log.d(TAG, "MyNumberViewModel - 생성자 호출")
        _currentValue.value = "HAPPY"
    }

    fun updateValue(actionType: ActionType, input : Int){
        when(actionType){
            ActionType.HAPPY->
                _currentValue.value = "HAPPY"
            ActionType.SAD->
                _currentValue.value = "SAD"
        }
    }

}