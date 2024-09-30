import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.presentation.MyViewModel

class MyViewModelFactory(private val getString: (Int) -> String) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MyViewModel::class.java)) {
            return MyViewModel(getString) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}