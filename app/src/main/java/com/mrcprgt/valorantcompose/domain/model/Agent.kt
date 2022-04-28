package com.mrcprgt.valorantcompose.domain.model

import androidx.compose.ui.semantics.Role

data class Agent(
    val uuid: String,
    val displayName: String,
    val description: String,
    val displayIcon: String,
    val fullPortraitV2: String,
    val role: Role,
    val abilities: List<Ability>
) {
    data class Role(
        val displayName: String,
        val description: String,
        val displayIcon: String,
    )

    data class Ability(
        val displayName: String,
        val description: String,
        val displayIcon: String?,
        val slot: AbilitySlot
    ) {
        enum class AbilitySlot {
            ABILITY1,
            ABILITY2,
            GRENADE,
            ULTIMATE,
            PASSIVE
        }
    }
}