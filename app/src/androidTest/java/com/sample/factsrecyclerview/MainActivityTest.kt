package com.sample.factsrecyclerview

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import com.sample.factsrecyclerview.model.FakeFactJson
import com.sample.factsrecyclerview.view.MainActivity
import com.sample.factsrecyclerview.view.adapter.FactsRecyclerViewAdapter
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class MainActivityTest {
    private val FACT_POSITION_TO_TEST: Int = 5

    @get: Rule
    var activityScenarioRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun isRecyclerViewVisibleOnActivityLaunch() {
        onView(
            withId(
                R.id.factsRecyclerView
            )
        ).check(
            matches(
                isDisplayed()
            )
        )
    }

    @Test
    fun scrollToItemAtPositionToClick() {
        try {
            Thread.sleep(5000)
        } catch (e: InterruptedException) {
            e.printStackTrace();
        }
        onView(
            withId(
                R.id.factsRecyclerView)
        ).perform(
            actionOnItemAtPosition<FactsRecyclerViewAdapter.FactViewHolder>(
                FACT_POSITION_TO_TEST,
                click()
            )
        )
    }
}