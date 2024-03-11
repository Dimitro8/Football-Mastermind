package com.football.mastermind.quiz.app.screens.test.view

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.football.mastermind.quiz.app.screens.test.data.TestButtonData
import com.football.mastermind.quiz.app.screens.test.data.TestData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun TestView(modifier: Modifier = Modifier, navController: NavHostController) {
    val testdata = mutableListOf(
        TestData(
            "Which goalkeeper scored more than 100 goals in his career?",
            arrayListOf(
                TestButtonData("Rene Higuita"),
                TestButtonData("Rogero Ceni"),
                TestButtonData("Igor Akinfeev"),
                TestButtonData("Jose Luis Chilavert")
            ),
            1
        ),
        TestData(
            "Which team won the first European Championship, held in 1960?",
            arrayListOf(
                TestButtonData("USSR"),
                TestButtonData("Yugoslavia"),
                TestButtonData("France"),
                TestButtonData("Italy")
            ),
            0
        ),
        TestData(
            "Which team won the first European Championship, held in 1960?",
            arrayListOf(
                TestButtonData("Russia"),
                TestButtonData("Italy"),
                TestButtonData("Germany"),
                TestButtonData("Brazil")
            ),
            3
        ),
        TestData(
            "The only goalkeeper to win the Ballon d'Or?",
            arrayListOf(
                TestButtonData("Jose Liz Chilavert"),
                TestButtonData("Lev Yashin"),
                TestButtonData("Igor Akinfeev"),
                TestButtonData("Rogero Ceni")
            ),
            1
        ),
        TestData(
            "The country that hosted the first FIFA World Cup?",
            arrayListOf(
                TestButtonData("USSR"),
                TestButtonData("Brazil"),
                TestButtonData("Italy"),
                TestButtonData("Uruguay")
            ),
            3
        ),
        TestData(
            "At what second was the world's fastest own goal scored?",
            arrayListOf(
                TestButtonData("20 second"),
                TestButtonData("50 second"),
                TestButtonData("17 second"),
                TestButtonData("14 seconds")
            ),
            2
        ),
        TestData(
            "Who won the 2014 World Cup golden boot?",
            arrayListOf(
                TestButtonData("Messi"),
                TestButtonData("Muller"),
                TestButtonData("Klose"),
                TestButtonData("James Rodriguez")
            ),
            3
        ),
        TestData(
            "Who won the 2014 World Cup golden glove?",
            arrayListOf(
                TestButtonData("Igor Akinfeev"),
                TestButtonData("Manuel Neuer"),
                TestButtonData("Keylor Navas"),
                TestButtonData("Guilherme Ochoa")
            ),
            1
        ),
        TestData(
            "Who won the 2014 World Cup Golden Ball?",
            arrayListOf(
                TestButtonData("Ronaldo"),
                TestButtonData("Messi"),
                TestButtonData("Klose"),
                TestButtonData("Neymar")
            ),
            1
        ),
    )

    var currentIndex by rememberSaveable { mutableIntStateOf(0) }
    val clickedButtonIndex = remember { mutableIntStateOf(-1) }
    val rightAnswersCount = remember { mutableIntStateOf(0) }
    val isTestEnded = remember { mutableStateOf(false) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(testdata.size) { index ->
                if (index == currentIndex) {
                    Text(
                        text = testdata[index].question,
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier
                            .padding(bottom = 50.dp)
                            .fillMaxWidth(),
                        textAlign = TextAlign.Center
                    )
                    testdata[index].answers.forEachIndexed { answersIndex, answerData ->
                        testdata[index].answers[answersIndex].color =
                            if (clickedButtonIndex.intValue == answersIndex) {
                                if (testdata[index].rightAnswer == answersIndex) Color.Green else Color.Red
                            } else {
                                Color.White
                            }
                        Button(
                            onClick = {
                                clickedButtonIndex.intValue = answersIndex
                                if (testdata[index].rightAnswer == answersIndex) {
                                    rightAnswersCount.intValue++
                                }
                                CoroutineScope(Dispatchers.Default).launch {
                                    delay(500)
                                    if (currentIndex < testdata.size - 1) {
                                        currentIndex++
                                    } else {
                                        isTestEnded.value = true
                                    }
                                    clickedButtonIndex.intValue = -1
                                }
                            },
                            shape = RoundedCornerShape(20.dp),
                            modifier = Modifier
                                .padding(top = 4.dp, start = 30.dp, end = 30.dp)
                                .border(
                                    3.dp,
                                    testdata[index].answers[answersIndex].color,
                                    RoundedCornerShape(20.dp)
                                )
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = answerData.answer,
                                style = MaterialTheme.typography.bodyLarge,
                                fontSize = 30.sp
                            )
                        }
                    }
                }
            }
        }
    }
    if (isTestEnded.value) {
        TestDialogView(
            onDismiss = {},
            title = rightAnswersCount.intValue.toString(),
            navController = navController
        )
    }
}