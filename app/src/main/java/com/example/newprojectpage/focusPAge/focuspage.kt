package com.example.newprojectpage.focusPAge

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ComposeCompilerApi
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.newprojectpage.R
import com.example.newprojectpage.ui.theme.NewProjectPageTheme

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
    val navController= rememberNavController()
    NavHost(navController = navController, startDestination =  "MainScreen"){
        composable("MainScreen"){
            myApp(imageId,names,definitons,navController)
        }
        composable("DetailScreen/{index}",
            arguments = listOf(
                navArgument(name="index"){
                    type= NavType.IntType
                }
            )
        ){index->
            DetailScreen(photos = imageId,
                names = names,
                definition = definitons,
                itemIndex = index.arguments?.getInt("index") ,
                navController=navController
            )
        }


    }

}
@Composable
fun myApp(imageId: Array<Int>,
          names: Array<String>,
          definitons: Array<String>,
          navController: NavController)
{
    Box(modifier = Modifier.fillMaxSize()){
        Image(painter = painterResource(id = R.drawable.image_2),
            contentDescription = " ",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.FillBounds)
        Text(text = "Let's Focus")

    }
    LazyColumn(contentPadding = PaddingValues(16.dp)){

        val itemCount=names.size
        items(itemCount){ item->
            ColumnItem(
                itemIndex=item,
                painter=imageId,
                title=names,
                definitons=definitons,
                navController=navController
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
    navController: NavController
) {
    Card (modifier = Modifier
        .padding(10.dp)
        .wrapContentSize()
        .clickable { navController.navigate("DetailScreen/$itemIndex") },
        colors = CardDefaults.cardColors(
            containerColor = Color.White.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(1.dp))
    {
        Row(modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.spacedBy(15.dp))
        {
            Text(text = title[itemIndex],
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp
            )
        }

    }
}

@Composable
@Preview (showBackground = true)
fun myAppPreview(){
    NewProjectPageTheme {
        exerciseData()
    }
}