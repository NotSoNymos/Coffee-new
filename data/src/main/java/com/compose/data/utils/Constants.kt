package com.compose.data.utils

import com.compose.data.models.OnboardingItemData

object Constants {
    val OnboardingItems = listOf(
        OnboardingItemData(
            "onboarding_first_background",
            "shader",
            "Embrace coffee essence",
            "Lorem ipsum dolor sit amet consectetur. Vestibulum eget blandit mattis"
        ),
        OnboardingItemData(
            "onboarding_second_background",
            "shader",
            "Flavorful bean journey",
            "Lorem ipsum dolor sit amet consectetur. Vestibulum eget blandit mattis"
        ),
        OnboardingItemData(
            "onboarding_third_background",
            "shader",
            "Unlock bean secrets",
            "Lorem ipsum dolor sit amet consectetur. Vestibulum eget blandit mattis",
            true
        )
    )
}
sealed class Destinations{
    object Main
    object Onboarding
    object Login
    object Registration
}