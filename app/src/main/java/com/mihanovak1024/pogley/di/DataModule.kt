package com.mihanovak1024.pogley.di

import com.mihanovak1024.pogley.inventory.data.repository.InventoryItemRepositoryImpl
import com.mihanovak1024.pogley.inventory.domain.repository.InventoryItemRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideInventoryItemRepository(inventoryItemRepositoryImpl: InventoryItemRepositoryImpl): InventoryItemRepository {
        // TODO: add datasources
        return inventoryItemRepositoryImpl
    }
}