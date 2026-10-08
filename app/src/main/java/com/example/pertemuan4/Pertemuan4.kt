package com.example.pertemuan4


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainAppContent() {
    var selectedTab by remember { mutableIntStateOf(0) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    var nameText by remember { mutableStateOf("") }
    var isChecked by remember { mutableStateOf(false) }
    var isSwitched by remember { mutableStateOf(true) }
    var openDialog by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pertemuan 4 : Material 3") },
                actions = {
                    IconButton(onClick = {
                        scope.launch {
                            snackbarHostState.showSnackbar("Tombol Favorit Ditekan")
                        }
                    }) {
                        Icon(Icons.Default.Favorite, contentDescription = "Favorit")
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Default.Home, contentDescription = "Home") },
                    label = { Text("Beranda") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )
                NavigationBarItem(
                    icon = {
                        BadgedBox(
                            badge = { Badge { Text("3") } }
                        ) {
                            Icon(Icons.Default.Notifications, contentDescription = "Notifikasi")
                        }
                    },
                    label = { Text("Notifikasi") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 }
                )
            }
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { openDialog = true }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Tambah Data")
            }
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            item {
                Text(
                    text = "1. Komponen Tindakan (Actions)",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = {
                        scope.launch { snackbarHostState.showSnackbar("Button Ditekan") }
                    }) {
                        Text("Filled Button")
                    }
                    OutlinedButton(onClick = { }) {
                        Text("Outlined")
                    }
                }
            }

            item { HorizontalDivider() }

            item {
                Text(
                    text = "2. Input Teks (Text Field)",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                OutlinedTextField(
                    value = nameText,
                    onValueChange = { nameText = it },
                    label = { Text("Nama Mahasiswa") },
                    placeholder = { Text("Masukkan nama...") },
                    modifier = Modifier.fillMaxWidth()
                )
            }

            item { HorizontalDivider() }

            item {
                Text(
                    text = "3. Komponen Pemilihan (Selection)",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Checkbox(
                            checked = isChecked,
                            onCheckedChange = { isChecked = it }
                        )
                        Text("Setuju Syarat")
                    }
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text("Aktifkan Fitur: ")
                        Switch(
                            checked = isSwitched,
                            onCheckedChange = { isSwitched = it }
                        )
                    }
                }
            }

            item { HorizontalDivider() }

            item {
                Text(
                    text = "4. Komponen Pembatasan (Containment)",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "Card",
                            style = MaterialTheme.typography.titleLarge
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Ini adalah contoh penggunaan komponen Card untuk mengelompokkan informasi.",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }

            item { HorizontalDivider() }

            item {
                Text(
                    text = "5. Indikator Proses (Communication)",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    CircularProgressIndicator()
                    LinearProgressIndicator(
                        modifier = Modifier.weight(1f)
                    )
                }
            }
        }
        if (openDialog) {
            AlertDialog(
                onDismissRequest = { openDialog = false },
                title = { Text("Konfirmasi Tindakan") },
                text = { Text("Apakah Anda yakin ingin memicu dialog ini dari FAB?") },
                confirmButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("Ya")
                    }
                },
                dismissButton = {
                    TextButton(onClick = { openDialog = false }) {
                        Text("Batal")
                    }
                }
            )
        }
    }
}