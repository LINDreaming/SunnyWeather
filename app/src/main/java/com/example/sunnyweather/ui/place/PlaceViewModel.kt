package com.example.sunnyweather.ui.place
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.example.sunnyweather.logic.Repository
import com.example.sunnyweather.logic.model.Place
import retrofit2.http.Query

class PlaceViewModel:ViewModel() {

    fun savePlace(place: Place) = Repository.savePlace(place)
    fun getSavedPlaced() = Repository.getSavedPlace()
    fun isPlaceSaved() = Repository.isPlaceSaved()

    private val searchLiveData = MutableLiveData<String>()
    val placeList = ArrayList<Place>()
    val  placeLiveData = Transformations.switchMap(searchLiveData) { query ->
        Repository.searchPlaces(query)
    }
    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

}