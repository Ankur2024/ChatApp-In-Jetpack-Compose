package com.example.whatsapp.presentation.updatescreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.whatsapp.R

@Composable
@Preview(showSystemUi = true)
fun TopBar() {
    var isSearching by remember { mutableStateOf(false) }
    var search by remember { mutableStateOf("") }
    var showMenu by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxWidth()
            .padding(top = 12.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 6.dp)
        ) {
            if (isSearching) {
                TextField(
                    value = search,
                    onValueChange = { search = it },
                    placeholder = { Text(text = "Search") },
                    colors = TextFieldDefaults.colors(
                        unfocusedContainerColor = Color.Transparent,
                        focusedContainerColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier.weight(1f),
                    singleLine = true
                )
                IconButton(onClick = {
                    isSearching = false
                    search = ""
                }) {
                    Icon(
                        painter = painterResource(R.drawable.cross),
                        contentDescription = "Close search",
                        modifier = Modifier.size(22.dp)
                    )
                }
            } else {
                Text(
                    "Updates",
                    fontSize = 28.sp,
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(start = 12.dp)
                )

                Spacer(modifier = Modifier.weight(1f))

                IconButton(onClick = { }) {
                    Icon(
                        painter = painterResource(R.drawable.camera),
                        contentDescription = "Camera",
                        modifier = Modifier.size(22.dp)
                    )
                }
                IconButton(onClick = { isSearching = true }) {
                    Icon(
                        painter = painterResource(R.drawable.search),
                        contentDescription = "Search",
                        modifier = Modifier.size(22.dp)
                    )
                }
                IconButton(onClick = {
                    showMenu = true
                }) {
                    Icon(
                        painter = painterResource(R.drawable.more),
                        contentDescription = "More",
                        modifier = Modifier.size(22.dp)
                    )

                    DropdownMenu(
                        expanded = showMenu,
                        onDismissRequest = { showMenu = false }
                    ) {
                        DropdownMenuItem(
                            text = { Text(text = "Status Privacy") },
                            onClick = { showMenu = false }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "Crate channel") },
                            onClick = { showMenu = false }
                        )
                        DropdownMenuItem(
                            text = { Text(text = "Settings") },
                            onClick = { showMenu = true }
                        )
                    }
                }
            }
        }
        HorizontalDivider()
    }
}
