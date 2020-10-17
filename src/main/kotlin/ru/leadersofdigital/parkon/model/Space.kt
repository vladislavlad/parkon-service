package ru.leadersofdigital.parkon.model

import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(schema = "parkon", name = "space")
data class Space(
        @ManyToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "park_id", referencedColumnName = "id")
        var park: Park,
        @Enumerated(EnumType.STRING)
        val type: SpaceType,
        @Enumerated(EnumType.STRING)
        val status: ParkingStatus,
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long
)