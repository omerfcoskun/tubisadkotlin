package com.omer.yemeksiparis.di

import com.omer.yemeksiparis.data.repo.YemeklerDaoRepository
import com.omer.yemeksiparis.retrofit.ApiUtils
import com.omer.yemeksiparis.retrofit.Yemeklerdao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideYemekelerDaoRepository(yemeklerdao:Yemeklerdao):YemeklerDaoRepository{
        return YemeklerDaoRepository(yemeklerdao)
    }

    @Provides
    @Singleton
    fun provideYemeklerdao():Yemeklerdao{
        return ApiUtils.getYemeklerdao()
    }
}