package com.mrcprgt.valorantcompose.data.mappers

import com.mrcprgt.valorantcompose.data.remote.RemoteAgentsResponse
import com.mrcprgt.valorantcompose.domain.model.Agent

fun RemoteAgentsResponse.RemoteAgentData.toDomain(): Agent =
    Agent(
        uuid = this.uuid,
        displayName = this.displayName,
        description = this.description,
        displayIcon = this.displayIcon,
        fullPortraitV2 = this.fullPortraitV2!!,
        role = this.role.toDomain(),
        abilities = this.abilities.map {
            Agent.Ability(
                displayName = it.displayName,
                displayIcon = it.displayIcon,
                description = it.description,
                slot = it.slot.toSlot()
            )
        }
    )

fun RemoteAgentsResponse.RemoteAgentData.Role.toDomain() = Agent.Role(
    displayName, description, displayIcon
)

fun String.toSlot(): Agent.Ability.AbilitySlot {
    return when {
        this.contentEquals("Ability1") -> Agent.Ability.AbilitySlot.ABILITY1
        this.contentEquals("Ability2") -> Agent.Ability.AbilitySlot.ABILITY2
        this.contentEquals("Grenade") -> Agent.Ability.AbilitySlot.GRENADE
        this.contentEquals("Ultimate") -> Agent.Ability.AbilitySlot.ULTIMATE
        this.contentEquals("Passive") -> Agent.Ability.AbilitySlot.PASSIVE
        else -> throw Exception("Invalid Slot Type")
    }
}