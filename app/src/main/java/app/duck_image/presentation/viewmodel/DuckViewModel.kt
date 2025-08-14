package app.duck_image.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.duck_image.domain.model.Duck
import app.duck_image.domain.usecase.GetRandomDuckUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DuckViewModel @Inject constructor(
    private val getRandomDuckUseCase: GetRandomDuckUseCase
) : ViewModel() {

    private val _duck = MutableStateFlow<Duck?>(null)
    val duck: StateFlow<Duck?> = _duck

    fun loadRandomDuck() {
        viewModelScope.launch {
            _duck.value = getRandomDuckUseCase()
        }
    }

}