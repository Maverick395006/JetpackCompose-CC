package com.example.jetpackcomposecc.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.jetpackcomposecc.R

@Composable
fun BlogCategory(@DrawableRes imgId: Int, title: String, subTitle: String) {
    Card(elevation = CardDefaults.cardElevation(8.dp), modifier = Modifier.padding(8.dp)) {
        Row(
            modifier = Modifier.padding(end = 8.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(id = imgId), contentDescription = "",
                modifier = Modifier
                    .size(48.dp)
                    .padding(8.dp)
                    .weight(.2f)
            )
            ItemDescription(title, subTitle, Modifier.weight(.8f))
        }
    }
}

@Composable
fun ItemDescription(title: String, subTitle: String, modifier: Modifier) {
    Column(modifier = modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.titleSmall
        )
        Text(
            text = subTitle,
            style = MaterialTheme.typography.bodySmall
        )
    }
}

@Preview
@Composable
fun BlogCategoryPreview() {
    BlogCategory(
        imgId = R.drawable.ic_apple,
        title = "Programming",
        subTitle = "Learn Different Languages"
    )
}


data class Category(val img: Int, val title: String, val subtitle: String)

fun getCategoryList(): MutableList<Category> {
    val list = mutableListOf<Category>()
    list.add(Category(R.drawable.ic_apple, "Apple", "Brand"))
    list.add(Category(R.drawable.ic_app_store, "Apple Store", "Utilisation"))
    list.add(Category(R.drawable.ic_apple_music, "Apple Music", "Entertainment"))
    list.add(Category(R.drawable.ic_apple_tv, "Apple TV", "Entertainment"))
    list.add(Category(R.drawable.ic_apple, "Apple", "Brand"))
    list.add(Category(R.drawable.ic_app_store, "Apple Store", "Utilisation"))
    list.add(Category(R.drawable.ic_apple_music, "Apple Music", "Entertainment"))
    list.add(Category(R.drawable.ic_apple_tv, "Apple TV", "Entertainment"))
    list.add(Category(R.drawable.ic_apple, "Apple", "Brand"))
    list.add(Category(R.drawable.ic_app_store, "Apple Store", "Utilisation"))
    list.add(Category(R.drawable.ic_apple_music, "Apple Music", "Entertainment"))
    list.add(Category(R.drawable.ic_apple_tv, "Apple TV", "Entertainment"))
    list.add(Category(R.drawable.ic_apple, "Apple", "Brand"))
    list.add(Category(R.drawable.ic_app_store, "Apple Store", "Utilisation"))
    list.add(Category(R.drawable.ic_apple_music, "Apple Music", "Entertainment"))
    list.add(Category(R.drawable.ic_apple_tv, "Apple TV", "Entertainment"))
    return list
}

@Preview(heightDp = 500)
@Composable
fun BlogCategoryListPreview() {
    LazyColumn(content = {
        items(getCategoryList()){item->
            BlogCategory(imgId = item.img, title = item.title, subTitle = item.subtitle)
        }
    })
}
