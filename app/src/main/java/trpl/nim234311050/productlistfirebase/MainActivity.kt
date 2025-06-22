package trpl.nim234311050.productlistfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import trpl.nim234311050.productlistfirebase.ui.theme.ProductListFirebaseTheme
import trpl.nim234311050.productlistfirebase.ui.theme.ProductListScreen
import trpl.nim234311050.productlistfirebase.viewmodel.ProductViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductListFirebaseTheme {
                val vm: ProductViewModel = viewModel()
                ProductListScreen(viewModel = vm)
            }
        }
    }
}

