package com.example.pertemuan4

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AdvanceLayout(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 60.dp, start = 16.dp, end = 16.dp, bottom = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.prodi),
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            text = stringResource(R.string.univ),
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(24.dp))

        Column(
            modifier = Modifier.weight(1f),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ItemCard(
                cardBgColor = colorResource(R.color.card_0_bg),
                nama = stringResource(R.string.nama),
                isCursive = true,
                noHp = null,
                alamat = stringResource(R.string.alamat),
                alamatColor = colorResource(R.color.text_yellow)
            )

            Spacer(modifier = Modifier.height(12.dp))

            ItemCard(
                cardBgColor = colorResource(R.color.card_1_bg),
                nama = stringResource(R.string.nama_1),
                isCursive = false,
                noHp = stringResource(R.string.phone_1),
                alamat = stringResource(R.string.alamat_1),
                alamatColor = colorResource(R.color.text_yellow)
            )

            Spacer(modifier = Modifier.height(12.dp))

            ItemCard(
                cardBgColor = colorResource(R.color.card_2_bg),
                nama = stringResource(R.string.nama_2),
                isCursive = false,
                noHp = stringResource(R.string.phone_2),
                alamat = stringResource(R.string.alamat_2),
                alamatColor = colorResource(R.color.text_white)
            )

            Spacer(modifier = Modifier.height(12.dp))

            ItemCard(
                cardBgColor = colorResource(R.color.card_3_bg),
                nama = stringResource(R.string.nama_3),
                isCursive = false,
                noHp = stringResource(R.string.phone_3),
                alamat = stringResource(R.string.alamat_3),
                alamatColor = colorResource(R.color.text_white)
            )
        }

        Text(
            text = stringResource(R.string.copy),
            fontSize = 12.sp,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}

@Composable
fun ItemCard(
    cardBgColor: Color,
    nama: String,
    isCursive: Boolean,
    noHp: String?,
    alamat: String,
    alamatColor: Color
) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = cardBgColor)
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = painterResource(R.drawable.logo_umy),
                contentDescription = null,
                modifier = Modifier.size(70.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column {
                Text(
                    text = nama,
                    fontSize = 22.sp,
                    fontWeight = FontWeight.Bold,
                    fontFamily = if (isCursive) FontFamily.Cursive else FontFamily.Default,
                    color = colorResource(R.color.text_white)
                )

                if (noHp != null) {
                    Text(
                        text = noHp,
                        fontSize = 14.sp,
                        color = colorResource(R.color.text_cyan)
                    )
                }

                Text(
                    text = alamat,
                    fontSize = 14.sp,
                    color = alamatColor
                )
            }
        }
    }
}