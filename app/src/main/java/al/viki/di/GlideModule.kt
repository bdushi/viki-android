package al.viki.di

import al.viki.foundation.R
import android.content.Context
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class GlideModule {
    @Singleton
    @Provides
    fun glide(@ApplicationContext app: Context): RequestManager =
        Glide
            .with(app)
            .applyDefaultRequestOptions(
                RequestOptions()
                    .error(ContextCompat.getDrawable(app, R.drawable.ic_outline_image_not_supported)?.also {
                        it.setTint(ContextCompat.getColor(app, R.color.vikiColorBackground))
                    })
                    .onlyRetrieveFromCache(true)
            )
}