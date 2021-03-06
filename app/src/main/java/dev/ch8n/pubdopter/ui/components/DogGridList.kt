package dev.ch8n.pubdopter.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import dev.ch8n.pubdopter.ui.theme.*
import dev.ch8n.pubdopter.ui.utils.Fake.doggies


@Composable
fun DogGridList(modifier: Modifier, onClick: (DogData) -> Unit) {

    val scrollState = rememberLazyListState()

    LazyColumn(
        modifier = modifier,
        state = scrollState
    ) {

        val data = doggies.chunked(2)

        items(data) { dog: List<DogData> ->

            Row(
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                DogPreviewCard(
                    modifier = Modifier
                        .width(dp200)
                        .height(dp250)
                        .padding(dp8),
                    dogData = dog[0],
                    onClick = onClick
                )

                DogPreviewCard(
                    modifier = Modifier
                        .width(dp200)
                        .height(dp250)
                        .padding(dp8),
                    dogData = dog[1],
                    onClick = onClick
                )
            }
        }

    }


}

@Preview(
    showBackground = true,
    heightDp = 200,
    widthDp = 200
)
@Composable
fun PreviewDogList() {
    PubDopterTheme {
        DogGridList(
            modifier = Modifier
                .fillMaxSize()
                .padding(dp16),
            onClick = {}
        )
    }
}