package com.example.w2_androidstudygroup

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.w2_androidstudygroup.ui.theme.parkinsansFamily

data class NavigationItem(
    val title: String,
    val iconSelected: ImageVector,
    val iconUnselected: ImageVector
)

@Composable
fun HomeScreen(navController: NavController? = null) {
    val screens = listOf(
        NavigationItem(
            "Home",
            Icons.Filled.Home,
            Icons.Outlined.Home
        ),
        NavigationItem(
            "Profile",
            Icons.Filled.Person,
            Icons.Outlined.Person
        ),
        NavigationItem(
            "Settings",
            Icons.Filled.Settings,
            Icons.Outlined.Settings
        ),
    )
    var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                screens.forEachIndexed { index, s ->
                    NavigationBarItem(
                        icon = {
                            if (selectedItemIndex == index) Icon(
                                s.iconSelected,
                                contentDescription = null
                            ) else Icon(
                                s.iconUnselected,
                                contentDescription = null
                            )
                        },
                        label = { Text(s.title) },
                        selected = selectedItemIndex == index,
                        onClick = {
                            selectedItemIndex = index
                        }
                    )
                }
            }
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it)
                    .padding(16.dp)
            ) {
                when (selectedItemIndex) {
                    0 -> HomeContent(navController = navController)
                    1 -> ProfileContent()
                    2 -> SettingsContent()
                }
            }
        }
    )
}

@Composable
fun HomeContent(navController: NavController? = null) {
    val members = listOf(
        MemberModel(
            "Wildan Syukri Niam",
            "Coordinator",
            "wildan_niam"
        ),
        MemberModel(
            "Moses Eliyada",
            "Vice Coordinator",
            "moses_eliyada"
        ),
        MemberModel(
            "Puri Lalita",
            "Administration",
            "puri_lalita"
        ),
        MemberModel(
            "M. Darrel Prawira",
            "Assistant Study Group",
            "darrel_prawira"
        ),
        MemberModel(
            "Adelia Nasywa",
            "Assistant Study Group",
            "adelia_nasywa"
        ),
        MemberModel(
            "M. Raihan Syahrin",
            "Assistant Study Group",
            "raihan_syahrin"
        ),
        MemberModel(
            "M. Arzu Kirana",
            "Assistant Study Group",
            "arzu_kirana"
        ),
        MemberModel(
            "Reinhard Efraim",
            "Assistant Study Group",
            "reinhard_efraim"
        ),
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        LazyColumn {
            items(members) { member ->
                MemberItem(
                    member.name,
                    member.role,
                    member.imageUrl,
                    onClick = {
                        navController?.navigate(
                            MemberDetail(
                                memberName = member.name,
                                memberRole = member.role,
                                memberImageUrl = member.imageUrl
                            )
                        )
                    }
                )

            }
        }
    }
}

@Composable
fun MemberItem(
    name: String,
    role: String,
    imageUrl: String,
    onClick: () -> Unit,
) {
    Card(
        modifier = Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth(),
        onClick = onClick
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
        ) {
            Image(
                painter = painterResource(
                    id = when (imageUrl) {
                        "wildan_niam" -> R.drawable.wildan_niam
                        "moses_eliyada" -> R.drawable.moses_eliyada
                        "puri_lalita" -> R.drawable.puri_lalita
                        "darrel_prawira" -> R.drawable.darrel_prawira
                        "adelia_nasywa" -> R.drawable.adelia_nasywa
                        "raihan_syahrin" -> R.drawable.raihan_syahrin
                        "arzu_kirana" -> R.drawable.arzu_kirana
                        "reinhard_efraim" -> R.drawable.reinhard_efraim
                        else -> android.R.drawable.ic_menu_gallery // Default image
                    }
                ),
                contentDescription = null,
                modifier = Modifier
                    .size(76.dp)
                    .padding(4.dp),
            )

            Spacer(modifier = Modifier.width(10.dp))

            Column {

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    name,
                    fontFamily = parkinsansFamily,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )

                Spacer(modifier = Modifier.height(3.dp))

                Text(
                    role,
                    fontFamily = parkinsansFamily,
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Normal
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewHomeScreen() {
    HomeScreen(navController = null)
}