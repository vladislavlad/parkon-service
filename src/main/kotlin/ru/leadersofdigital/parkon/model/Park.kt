package ru.leadersofdigital.parkon.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table


@Entity
@Table(schema = "parkon", name = "parks")
data class Park(
        var longitude: Double,
        var latitude: Double,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
)