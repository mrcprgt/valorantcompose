package com.mrcprgt.valorantcompose.data.remote


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class RemoteAgentsResponse(
    @Json(name = "data")
    val `data`: List<RemoteAgentData>,
    @Json(name = "status")
    val status: Int
) {
    @JsonClass(generateAdapter = true)
    data class RemoteAgentData(
        @Json(name = "abilities")
        val abilities: List<Ability>,
        @Json(name = "assetPath")
        val assetPath: String,
        @Json(name = "background")
        val background: Any?,
        @Json(name = "backgroundGradientColors")
        val backgroundGradientColors: Any?,
        @Json(name = "bustPortrait")
        val bustPortrait: String?,
        @Json(name = "characterTags")
        val characterTags: Any?,
        @Json(name = "description")
        val description: String,
        @Json(name = "developerName")
        val developerName: String,
        @Json(name = "displayIcon")
        val displayIcon: String,
        @Json(name = "displayIconSmall")
        val displayIconSmall: String,
        @Json(name = "displayName")
        val displayName: String,
        @Json(name = "fullPortrait")
        val fullPortrait: String?,
        @Json(name = "fullPortraitV2")
        val fullPortraitV2: String?,
        @Json(name = "isAvailableForTest")
        val isAvailableForTest: Boolean,
        @Json(name = "isBaseContent")
        val isBaseContent: Boolean,
        @Json(name = "isFullPortraitRightFacing")
        val isFullPortraitRightFacing: Boolean,
        @Json(name = "isPlayableCharacter")
        val isPlayableCharacter: Boolean,
        @Json(name = "killfeedPortrait")
        val killfeedPortrait: String,
        @Json(name = "role")
        val role: Role,
        @Json(name = "uuid")
        val uuid: String,
        @Json(name = "voiceLine")
        val voiceLine: VoiceLine
    ) {
        @JsonClass(generateAdapter = true)
        data class Ability(
            @Json(name = "description")
            val description: String,
            @Json(name = "displayIcon")
            val displayIcon: String?,
            @Json(name = "displayName")
            val displayName: String,
            @Json(name = "slot")
            val slot: String
        )

        @JsonClass(generateAdapter = true)
        data class Role(
            @Json(name = "assetPath")
            val assetPath: String,
            @Json(name = "description")
            val description: String,
            @Json(name = "displayIcon")
            val displayIcon: String,
            @Json(name = "displayName")
            val displayName: String,
            @Json(name = "uuid")
            val uuid: String
        )

        @JsonClass(generateAdapter = true)
        data class VoiceLine(
            @Json(name = "maxDuration")
            val maxDuration: Double,
            @Json(name = "mediaList")
            val mediaList: List<Media>,
            @Json(name = "minDuration")
            val minDuration: Double
        ) {
            @JsonClass(generateAdapter = true)
            data class Media(
                @Json(name = "id")
                val id: Int,
                @Json(name = "wave")
                val wave: String,
                @Json(name = "wwise")
                val wwise: String
            )
        }
    }
}