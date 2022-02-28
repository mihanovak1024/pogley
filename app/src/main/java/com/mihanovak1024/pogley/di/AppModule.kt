package com.mihanovak1024.pogley.di

import com.mihanovak1024.pogley.util.TimberDebugTree
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import timber.log.Timber
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @Singleton
    @Named("timber_debug_tree")
    abstract fun provideDebugTree(debugTree: TimberDebugTree): Timber.Tree

}