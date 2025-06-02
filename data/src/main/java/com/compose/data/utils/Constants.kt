package com.compose.data.utils

import com.compose.data.models.OnboardingItemData
import kotlinx.serialization.Serializable

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

sealed class Destinations {
    @Serializable
    object Login

    @Serializable
    object Register

    @Serializable
    object Onboarding

    @Serializable
    data class Scan(
        val value: String
    )

    @Serializable
    object Main

    @Serializable
    object Options


    companion object {
        var bottomBarEnabledItems = listOf(
            Main,
            Onboarding
        )

        fun tryParse(objName: String): Any? {
            return Destinations::class.nestedClasses
                .firstOrNull { it.simpleName == objName && it.objectInstance != null }
                ?.objectInstance
        }

        fun isBottomBarShouldBeShown(destinationName: String): Boolean {
            val obj = tryParse(destinationName)
            return bottomBarEnabledItems.contains(obj)
        }
    }
}