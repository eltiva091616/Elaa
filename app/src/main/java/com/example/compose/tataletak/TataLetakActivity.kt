package com.example.compose.tataletak

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.textInputServiceFactory
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose.R
import com.example.compose.ui.theme.AndroidTrainingTheme
import androidx.compose.foundation.layout.Column
import com.example.compose.ui.theme.ComposeTheme


class TataLetakActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeTheme {
                Column() {
                    SearchBar ()
                    Row() {
                        AlignYourBodyElement(
                            text = R.string.ab1_inversions,
                            drawable = R.drawable.img
                        )
                        AlignYourBodyElement(
                            text = R.string.ab2_inversions,
                            drawable = R.drawable.img
                        )
                        AlignYourBodyElement(
                            text = R.string.ab3_inversions,
                            drawable = R.drawable.img
                        )
                        AlignYourBodyElement(
                            text = R.string.ab4_inversions,
                            drawable = R.drawable.img
                        )
                    }
                    Row() {
                        FavoriteCollectionCard(
                            text = R.string.ab1_inversions,
                            drawable = R.drawable.img
                        )
                        FavoriteCollectionCard(
                            text = R.string.ab2_inversions,
                            drawable = R.drawable.img
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier){
    TextField(
        value = "",
        onValueChange = {},
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null
            )
        },
        placeholder = {
            Text(stringResource(id = R.string.placeholder_search))
        },
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = MaterialTheme.colors.surface
        ),
        modifier = modifier
            .fillMaxWidth()
            .heightIn(min = 56.dp))
}

@Composable
fun AlignYourBodyElement(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier){
    Column(modifier = modifier.padding (8.dp), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)

        )
        Text(
            text = stringResource(text),
            modifier = Modifier.paddingFromBaseline(
                top = 24.dp, bottom = 8.dp
            )
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    @DrawableRes drawable: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Surface(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row ( verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.width(192.dp)
        ){

            Image(
                painter = painterResource(id=drawable),
                contentDescription = null

            )
            Text(
                text = stringResource(id = text)
            )
        }
    }
}
