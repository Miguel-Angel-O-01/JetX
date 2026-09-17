package com.example.jetx.domain.autenticacion

interface AuthRepository {
    suspend fun signIn(): Result<AuthUser>
    suspend fun signOut()
}