package com.example.newprojectpage

import android.annotation.SuppressLint
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PointMode
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.newprojectpage.ui.theme.NewProjectPageTheme
import kotlinx.coroutines.delay
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.sin

@SuppressLint("RememberReturnType")
@Composable
fun timer(
    totalTime:Long,
    handleColor: Color,
    inactiveBarColor:Color,
    activeBarColor:Color,
    modifier: Modifier=Modifier,
    initialvalue: Float=1f,
    strokeWidth: Dp =5.dp
){
    var size by remember {
        mutableStateOf(IntSize.Zero)
    }
    var value by remember {
        mutableStateOf(initialvalue)
    }
    var currentTime by remember {
        mutableStateOf(totalTime)
    }
    var isTimerRunning by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(key1 = currentTime, key2 = isTimerRunning){
        if (currentTime>0 && isTimerRunning){
            delay(100L)
            currentTime-=100L
            value=currentTime/totalTime.toFloat()
        }
    }
    Box(contentAlignment = Alignment.Center,
        modifier = modifier.onSizeChanged { size=it })
    {
         Canvas(modifier = modifier){
             drawArc(
                 color = inactiveBarColor,
                 startAngle = -215f,
                 sweepAngle = 250f,
                 useCenter = false,
                 size = Size(size.width.toFloat(),size.height.toFloat()),
                 style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
             )
             drawArc(
                 color = activeBarColor,
                 startAngle = -215f,
                 sweepAngle = 250f*value,
                 useCenter = false,
                 size = Size(size.width.toFloat(),size.height.toFloat()),
                 style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
             )
             val center= Offset(size.width/2f, size.height/2f)
             val beta=(250f*value+145f)*(PI/180f).toFloat()
             val r=size.width/2f
             val a = cos(beta)*r
             val b = sin(beta)*r
             drawPoints(
                 listOf(Offset( center.x+a,center.y+b)),
                 pointMode = PointMode.Points,
                 color = handleColor,
                 strokeWidth=(strokeWidth*3f).toPx(),
                 cap = StrokeCap.Round
             )
         }
        Text(text = (currentTime / 1000L).toString(),
            fontSize = 44.sp,
            fontWeight = FontWeight.Bold,
            color = Color.DarkGray
        )
        IconButton(onClick = {
            if(currentTime<=0L){
                currentTime=totalTime
                isTimerRunning=true
            }else{
                isTimerRunning=!isTimerRunning
            }
        }, modifier = Modifier
            .align(Alignment.BottomCenter)
            .clip(shape = CircleShape)
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        colorResource(id = R.color.timerbg2).copy(alpha = 0.5f),
                        colorResource(id = R.color.timerbg1).copy(alpha = 0.5f)
                    )
                )
            )
        ) {
            Icon(painter = if(isTimerRunning && currentTime>=0L) painterResource(id = R.drawable.pause)
            else if (!isTimerRunning && currentTime >=0L) painterResource(id = R.drawable.play_arrow)
            else painterResource(id = R.drawable.stop), contentDescription =" " ,
                modifier = Modifier.size(38.dp),
                tint = colorResource(id = R.color.buttoncolor)
            )
        }





    }
}
@Composable
fun mainSurface(){
    Box(contentAlignment = Alignment.Center){
        timer(totalTime = 1500L * 1000L,
            handleColor = colorResource(id = R.color.pagemaincolor),
            inactiveBarColor = Color.DarkGray,
            activeBarColor = colorResource(id = R.color.pagemaincolor),
            modifier = Modifier.size(200.dp))
    }
}
@Composable
@Preview (showBackground = true)
fun timerPreview(){
        NewProjectPageTheme {
            mainSurface()
        }
}


