
package com.luisenrique.sportshub.data.local

import com.luisenrique.sportshub.data.local.entities.PlayerEntity
import com.luisenrique.sportshub.domain.model.User

data class SampleDataPayload(val user: User,
    )

object SampleData {
    fun create(): SampleDataPayload {
        return SampleDataPayload(
            user = User(
                id = "u1",
                fullName = "Nombre Apellido",
                userName = "nombreusuario",
                email = "user@mail.com",
                memberSince = "2024-03-12",
                verified = true
            )
        )

    }
}