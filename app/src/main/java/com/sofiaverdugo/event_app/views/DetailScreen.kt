package com.sofiaverdugo.event_app.views

import android.R.id.bold
import android.media.Image
import android.widget.Toast
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sofiaverdugo.event_app.models.EventRepo
import com.sofiaverdugo.event_app.ui.theme.EventappTheme
import com.sofiaverdugo.event_app.viewmodels.EventVM
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccessTimeFilled
import androidx.compose.material.icons.filled.AttachMoney
import androidx.compose.material.icons.filled.CalendarMonth
import androidx.compose.material.icons.filled.CalendarToday
import androidx.compose.material.icons.filled.ChevronLeft
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.HeartBroken
import androidx.compose.material.icons.filled.Link
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextOverflow
import com.sofiaverdugo.event_app.ui.theme.fontFamilyMontserrat
import java.time.LocalDateTime

val VM =  EventVM(EventRepo())
@Composable
fun DetailScreen(viewModel: EventVM, eventId: Int, onBack: () -> Unit) {
    val context = LocalContext.current
    val events by viewModel.events
    val event = events.first { it.id == eventId }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(Color(0xFF1A3989))
    ) {
        Image(
            painter = painterResource(event.photo),
            contentDescription = event.title,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxSize()
                .graphicsLayer() {
                    alpha = 0.5f
                }
        )

        Column(
            modifier = Modifier
                .height(300.dp)
                .padding(24.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Button(
                    onClick = onBack,
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.ChevronLeft,
                        contentDescription = "Back",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(24.dp)
                    )
                }

                Button(
                    onClick = { Toast.makeText(context, "Compartiendo...", Toast.LENGTH_SHORT).show()},
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        imageVector = Icons.Default.Share,
                        contentDescription = "Compartir",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }


            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Button(
                    onClick = { viewModel.setLike(event.id) },
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    shape = CircleShape,
                    colors = if(!event.hasLiked){ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    )} else {
                        ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary
                        )
                    },
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Icon(
                        imageVector = if(!event.hasLiked){Icons.Default.FavoriteBorder} else {Icons.Default.Favorite},
                        contentDescription = "Like",
                        tint = if(!event.hasLiked){MaterialTheme.colorScheme.tertiary} else {Color.White},
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 300.dp)
                .background(
                    color = Color.White,
                    shape = RoundedCornerShape(
                        topStart = 32.dp,
                        topEnd = 32.dp
                    )
                )
                .verticalScroll(rememberScrollState())
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.85f),
                    verticalArrangement = Arrangement.spacedBy(2.dp)
                ) {
                    Text(event.title, style = MaterialTheme.typography.titleLarge, fontWeight = FontWeight.SemiBold)
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(4.dp)

                    ) {
                        Icon(
                            imageVector = Icons.Default.LocationOn,
                            contentDescription = null,
                            tint = MaterialTheme.colorScheme.tertiary,
                            modifier = Modifier.size(14.dp)
                        )
                        Text(event.location,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.tertiary
                        )

                    }
                }
                DateItem(event.dateTime)
            }
            Spacer(
                modifier = Modifier
                    .fillMaxSize()
                    .height(1.dp)
                    .background(color = Color.Gray)
                )
            Column() {
                Text("Descripción", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                Text(event.description,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.secondary)
            }

            Column() {
                Text("Detalles", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.SemiBold)
                Column( verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.weight(1f),
                            verticalArrangement = Arrangement.spacedBy(4.dp)

                        ) {
                            DetailItem(
                                detailTitle = "Fecha",
                                detailBody = "${event.dateTime.dayOfWeek} ${event.dateTime.dayOfMonth} de ${event.dateTime.month}",
                                icon = Icons.Default.CalendarMonth
                            )
                            DetailItem("Lugar", event.location, Icons.Default.LocationOn)
                     }
                        Column(
                            horizontalAlignment = Alignment.Start,
                            modifier = Modifier.weight(0.5f),
                            verticalArrangement = Arrangement.spacedBy(4.dp)
                        ) {
                            DetailItem("Horario", "${event.dateTime.hour.toString()}:${event.dateTime.minute.toString()}", Icons.Default.AccessTimeFilled)
                            DetailItem("Costo", event.cost, Icons.Default.AttachMoney)
                        }
                    }
                    DetailItem("Registro", event.registerLink, Icons.Default.Link)

                }

            }

            Row( modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ){
                Button(
                    onClick = { viewModel.setInterested(event.id) },
                    modifier = Modifier.weight(0.5f),
                    colors = if(!event.isInterested){
                        ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )} else {
                        ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.onPrimary,
                            contentColor = MaterialTheme.colorScheme.primary
                        )},
                    border = if(!event.isInterested){
                        BorderStroke(0.dp, MaterialTheme.colorScheme.primary)
                    } else {
                        BorderStroke(2.dp, MaterialTheme.colorScheme.primary)
                    }

                ) {
                    Text(
                        if (event.isInterested) "Te interesa"
                        else "Me interesa"
                    )
                }

                Button(
                    onClick = { Toast.makeText(context, "Agregando al calendario...", Toast.LENGTH_SHORT).show()},
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape),
                    shape = CircleShape,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.White
                    ),
                    contentPadding = PaddingValues(0.dp),
                    border = BorderStroke(1.dp, MaterialTheme.colorScheme.tertiary)
                ) {
                    Icon(
                        imageVector = Icons.Default.CalendarToday,
                        contentDescription = "Calendario",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
        }
    }
}




@Composable
fun DetailItem(
    detailTitle: String,
    detailBody: String,
    icon: ImageVector
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = CircleShape
                ),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(20.dp)
            )
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(-2.dp)
        ) {
            Text(
                text = detailTitle,
                style = MaterialTheme.typography.titleSmall
            )

            Text(
                text = detailBody,
                style = MaterialTheme.typography.labelSmall,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                color = MaterialTheme.colorScheme.secondary
            )
        }

    }
}

@Composable
fun DateItem(date: LocalDateTime){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(32.dp)
                .background(
                    color = MaterialTheme.colorScheme.primary,
                    shape = RoundedCornerShape(12.dp)
                ),
            contentAlignment = Alignment.Center
        ) {
            Text(date.dayOfMonth.toString(),
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.onPrimary)
        }
        Text(date.month.toString().take(3), style = MaterialTheme.typography.bodySmall)

    }

}


@Preview(showBackground = true)
@Composable
fun DetailScreenPreview() {
    EventappTheme() {
        DetailScreen( VM, eventId = 1, onBack = { })
    }
}