package app.duck_image.di

import app.duck_image.data.remote.DuckApi
import app.duck_image.data.repo_impl.DuckRepositoryImpl
import app.duck_image.domain.repo.DuckRepository
import app.duck_image.domain.usecase.GetRandomDuckUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    private const val BASE_URL = "https://random-d.uk/api/v2/"

    @Provides
    @Singleton
    fun provideRetrofit(): DuckApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(OkHttpClient.Builder().build())
            .build()
            .create(DuckApi::class.java)
    }

    @Provides
    @Singleton
    fun provideDuckRepository(api: DuckApi): DuckRepository {
        return DuckRepositoryImpl(api)
    }

    @Provides
    @Singleton
    fun provideGetRandomDuckUseCase(repository: DuckRepository): GetRandomDuckUseCase {
        return GetRandomDuckUseCase(repository)
    }
}