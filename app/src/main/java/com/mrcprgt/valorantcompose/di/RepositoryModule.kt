package com.mrcprgt.valorantcompose.di

import com.mrcprgt.valorantcompose.data.repository.AgentsRepository
import com.mrcprgt.valorantcompose.domain.gateway.AgentsGateway
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindAgentRepository(
        agentRepository: AgentsRepository
    ): AgentsGateway
}