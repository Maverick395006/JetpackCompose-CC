package com.example.jetpackcomposecc

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetpackcomposecc.screens.QuoteDetail
import com.example.jetpackcomposecc.screens.QuoteList
import com.example.jetpackcomposecc.screens.QuoteListScreen
import com.example.jetpackcomposecc.ui.theme.JetpackComposeCCTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

const val MY_TAG = "Maverick Universe"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(Dispatchers.IO).launch {
            delay(3000)
            DataManager.loadAssetFromFile(applicationContext)
        }

        setContent {
            JetpackComposeCCTheme {
                CoroutineScopeComposable()
            }
        }

    }
}


/**
 * Simple [Greeting] Text
 */

@Composable
fun Greeting() {
    Text(
        text = "Hello Maverick",
        fontStyle = FontStyle.Italic,
        fontWeight = FontWeight.ExtraBold,
        color = Color.Magenta,
        fontSize = 24.sp,
        textAlign = TextAlign.Center
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    JetpackComposeCCTheme {
        Greeting()
    }
}


/**
 * [TextInput]
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextInput() {
    val state = remember { mutableStateOf("") }
    TextField(
        value = state.value,
        onValueChange = {
            state.value = it
            Log.d(MY_TAG, it)
        },
        label = { Text(text = "Enter Message") },
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun TextInputPreview() {
    JetpackComposeCCTheme {
        TextInput()
    }
}


/**
 * [Column] & [Row] alternative of Linear layout
 */

@Composable
fun ColumnRow() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "A", fontSize = 24.sp)
        Divider()
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "A", fontSize = 24.sp)
            Text(text = "B", fontSize = 24.sp)
            Text(text = "C", fontSize = 24.sp)
        }
        Divider()
        Text(text = "C", fontSize = 24.sp)
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ColumnRowPreview() {
    JetpackComposeCCTheme {
        ColumnRow()
    }
}


/**
 * [Box] alternative of constraint/frame layout.
 */

@Composable
fun BoxComposable() {
    Box(contentAlignment = Alignment.BottomEnd) {
        Image(
            painter = painterResource(R.drawable.ic_apple_tv),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(color = Color.DarkGray)
        )
        Image(
            painter = painterResource(R.drawable.ic_apple),
            contentDescription = null,
            contentScale = ContentScale.Inside,
            colorFilter = ColorFilter.tint(color = Color.LightGray)
        )
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun BoxComposablePreview() {
    JetpackComposeCCTheme {
        BoxComposable()
    }
}


/**
 * [ListItemView] Strategically making [RecyclerView].
 */

@Composable
fun ListItemView(imgId: Int, name: String, occupation: String, modifier: Modifier) {
    Row(
        modifier.padding(20.dp)
    ) {
        Image(
            painter = painterResource(id = imgId),
            contentDescription = "",
            Modifier.size(40.dp)
        )
        Column(
            Modifier.padding(start = 8.dp)
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = occupation,
                fontWeight = FontWeight.Thin,
                fontSize = 12.sp
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ListItemViewPreview() {
    JetpackComposeCCTheme {
        Column() {
            ListItemView(R.drawable.ic_apple, "John Doe", "Software Developer", Modifier)
            ListItemView(R.drawable.ic_apple_tv, "Johnny Depp", "Television Star", Modifier)
            ListItemView(R.drawable.ic_apple_music, "avicii", "Music Composer", Modifier)
            ListItemView(R.drawable.ic_app_store, "Jeff bezos", "Store Keeper", Modifier)
        }
    }
}

/**
 * [Modifier]
 */

@Preview(showBackground = true, widthDp = 300, heightDp = 500)
@Composable
private fun ModifierPreview() {
    Text(text = "Hello",
        color = Color.White,
        modifier = Modifier
            .background(Color.Blue)
            .size(200.dp)
            .padding(36.dp)
            .clip(CircleShape)
            .background(Color.Yellow)
            .clickable { }
    )
}


/**
 * [CircularImage] using [Modifier]
 */

@Composable
fun CircularImage() {
    Image(
        painter = painterResource(id = R.drawable.ic_apple),
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(200.dp)
            .clip(CircleShape)
            .clickable { }
            .border(2.dp, Color.LightGray, CircleShape),
        contentDescription = "",
    )
}

@Composable
fun QuoteApp() {
    if (DataManager.isDataLoaded.value) {

        if (DataManager.currentPageType.value == PAGE_TYPE.QUOTE_LIST) {
            QuoteListScreen(data = DataManager.data) { quote ->
                DataManager.switchPage(quote)
            }
        } else {
            DataManager.currentQuote?.let { QuoteDetail(quote = it) }
        }

    } else {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(1f)
        ) {
            Text(text = "Loading.....", style = MaterialTheme.typography.headlineSmall)
        }
    }
}

enum class PAGE_TYPE {
    QUOTE_LIST,
    QUOTE_DETAIL
}

/**
 * [SideEffects] -> [LaunchedEffect]
 */

var counter = 1

@Composable
fun HasSideEffect() {
    counter++
    Text(text = "Maverick")
}

@Composable
fun ListComposable() {
    val categoryState = remember {
        mutableStateOf(emptyList<String>())
    }

    LaunchedEffect(key1 = false) {
        categoryState.value = fetchCategories()
        Log.d(MY_TAG, "CALLED")
    }

    LazyColumn {
        items(categoryState.value) { item ->
            Text(text = item)
        }
    }

}

fun fetchCategories(): List<String> {
    //assuming network call
    return listOf("One", "Two", "Three", "four")
}

@Composable
fun Counter() {
    var count = remember {
        mutableStateOf(0)
    }
    var key = count.value % 3 == 0

    LaunchedEffect(key1 = key) {
        Log.d(MY_TAG, "Current count: ${count.value}")
    }
    Button(onClick = { count.value++ }) {
        Text(text = "Increment Count")
    }
}

/**
 * [LaunchedEffect]
 *
 * v/s
 *
 * [RememberCoroutineScope] : This is useful for event-based functionality [As Example: onClick],
 *                            We can get Exceptions while config changes by using this, Nothing Special.
 *
 */


@Composable
fun LaunchedEffectComposable() {
    val counter = remember {mutableStateOf(0)}

    LaunchedEffect(key1 = Unit) {
        Log.d(MY_TAG, "Started...")
        try {
            for (i in 1..10) {
                counter.value++
                delay(1000L)
            }
        } catch (e: Exception) {
            Log.d(MY_TAG, "Exception- ${e.message.toString()}")
        }
    }

    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }
    Text(text = text)
}
@Composable
fun CoroutineScopeComposable() {
    val counter = remember {mutableStateOf(0)}
    val scope = rememberCoroutineScope()

    var text = "Counter is running ${counter.value}"
    if (counter.value == 10) {
        text = "Counter stopped"
    }
    Column{
        Text(text = text)
        Button(onClick = {
            scope.launch {
                Log.d(MY_TAG, "CoroutineScopeComposable, Started...")
                try {
                    for (i in 1..10) {
                        counter.value++
                        delay(1000L)
                    }
                } catch (e: Exception) {
                    Log.d(MY_TAG, "CoroutineScopeComposable, Exception- ${e.message.toString()}")
                }
            }
        }) {
            Text(text = "Start")
        }
    }
}