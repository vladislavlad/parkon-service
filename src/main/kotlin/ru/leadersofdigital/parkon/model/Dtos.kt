package ru.leadersofdigital.parkon.model

data class StatusDto(
        val status: String,
        val up: Boolean
)

data class ParkDto(
        var id: Long? = null,
        var latitude: Double? = null,
        var longitude: Double? = null
)

data class SpaceDto(
        var id: Long? = null,
        var number: Int? = null,
        var type: SpaceType? = null,
        var status: ParkingStatus? = null
)

enum class SpaceType {
    PARKING,
    FOR_DISABLED,
    FORBIDDEN,
}

enum class ParkingStatus {
    VACANT,
    BUSY,
    PARTIALLY_BUSY
}
