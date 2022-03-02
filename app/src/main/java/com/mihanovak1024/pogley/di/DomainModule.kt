package com.mihanovak1024.pogley.di

import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository
import com.mihanovak1024.pogley.inventory.domain.usecase.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DomainModule {

    @Provides
    @Singleton
    fun provideInventoryItemUseCases(repository: InventoryItemRepository): InventoryItemUseCases {
        return InventoryItemUseCases(
            getInventoryItems = GetInventoryItemsUseCase(repository),
            getInventoryItemById = GetInventoryItemByIdUseCase(repository),
            addInventoryItem = AddInventoryItemUseCase(repository),
            deleteInventoryItem = DeleteInventoryItemUseCase(repository)
        )
    }
}