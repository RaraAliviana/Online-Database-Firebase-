package trpl.nim234311050.productlistfirebase.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import trpl.nim234311050.productlistfirebase.data.Product
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products: StateFlow<List<Product>> = _products

    init {
        fetchProducts()
    }

    private fun fetchProducts() {
        viewModelScope.launch {
            FirebaseFirestore.getInstance().collection("products")
                .addSnapshotListener { snapshot, _ ->
                    val items = snapshot?.documents?.mapNotNull {
                        it.toObject(Product::class.java)
                    } ?: emptyList()
                    _products.value = items
                }
        }
    }
}
