package com.mihanovak1024.pogley.di

import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository
import com.mihanovak1024.pogley.inventory.domain.usecase.AddInventoryItemUseCase
import com.mihanovak1024.pogley.inventory.domain.usecase.DeleteInventoryItemUseCase
import com.mihanovak1024.pogley.inventory.domain.usecase.GetInventoryItemsUseCase
import com.mihanovak1024.pogley.inventory.domain.usecase.InventoryItemUseCases
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
            addInventoryItem = AddInventoryItemUseCase(repository),
            deleteInventoryItem = DeleteInventoryItemUseCase(repository)
        )
    }
}