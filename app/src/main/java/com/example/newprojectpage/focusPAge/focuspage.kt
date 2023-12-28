package com.example.newprojectpage.focusPAge

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.newprojectpage.R

@Composable
fun exerciseData(){
    val imageId= arrayOf(
        R.drawable.meditation_and_focus_image,
        R.drawable.meditation_and_focus_image,
        R.drawable.mental_break_activities_image,
        R.drawable.quick_scan_and_learn_image,
        R.drawable.concentration_meditation_image,
        R.drawable.time_management_skills_image
    )
    val names= arrayOf(
        "Pomodoro Technique",
        "Meditation and Focus Exercises",
        "Mental Break Activities",
        "Quick Scan and Learn",
        "Concentration Meditation",
        "Time Management Skills"
    )
    val definitons= arrayOf(
        "The Pomodoro Technique is a working method developed to increase time management and productivity. Created by Francesco Cirillo in the 1980s, this technique suggests working uninterrupted for a certain period of time, followed by a short break. Pomodoro means tomato in Italian and is named after the shape of a kitchen timer (stopwatch) that Cirillo used.",
        "The Pomodoro Technique is a working method developed to increase time management and productivity. Created by Francesco Cirillo in the 1980s, this technique suggests working uninterrupted for a certain period of time, followed by a short break. Pomodoro means tomato in Italian and is named after the shape of a kitchen timer (stopwatch) that Cirillo used.",
        "The Pomodoro Technique is a working method developed to increase time management and productivity. Created by Francesco Cirillo in the 1980s, this technique suggests working uninterrupted for a certain period of time, followed by a short break. Pomodoro means tomato in Italian and is named after the shape of a kitchen timer (stopwatch) that Cirillo used.",
        "The Pomodoro Technique is a working method developed to increase time management and productivity. Created by Francesco Cirillo in the 1980s, this technique suggests working uninterrupted for a certain period of time, followed by a short break. Pomodoro means tomato in Italian and is named after the shape of a kitchen timer (stopwatch) that Cirillo used.",
        "The Pomodoro Technique is a working method developed to increase time management and productivity. Created by Francesco Cirillo in the 1980s, this technique suggests working uninterrupted for a certain period of time, followed by a short break. Pomodoro means tomato in Italian and is named after the shape of a kitchen timer (stopwatch) that Cirillo used.",
        "The Pomodoro Technique is a working method developed to increase time management and productivity. Created by Francesco Cirillo in the 1980s, this technique suggests working uninterrupted for a certain period of time, followed by a short break. Pomodoro means tomato in Italian and is named after the shape of a kitchen timer (stopwatch) that Cirillo used."
    )
    myApp(imageId,names,definitons)

}
@Composable
fun myApp(imageId: Array<Int>,
          names: Array<String>,
          definitons: Array<String>)
{
    LazyColumn(contentPadding = PaddingValues(16.dp)){
        val itemCount=names.size
        items(itemCount){ item->
            ColumnItem(
                itemIndex=item,
                painter=imageId,
                title=names,
                definitons=definitons
            )

        }
    }

}

@Composable
fun ColumnItem(
    itemIndex: Int,
    painter: Array<Int>,
    title: Array<String>,
    definitons: Array<String>,
) {
    Card (modifier = Modifier
        .padding(10.dp)
        .wrapContentSize(),
        colors = CardDefaults.cardColors(
            containerColor = Color.White
        ),
        elevation = CardDefaults.cardElevation(10.dp))
    {
        Row(modifier = Modifier.fillMaxWidth())
        {

        }
    }
}
