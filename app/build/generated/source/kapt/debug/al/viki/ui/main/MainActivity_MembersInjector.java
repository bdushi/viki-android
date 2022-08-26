package al.viki.ui.main;

import al.bruno.core.interceptor.AuthorizationInterceptor;
import al.bruno.core.interceptor.RefreshTokenInterceptor;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MainActivity_MembersInjector implements MembersInjector<MainActivity> {
  private final Provider<AuthorizationInterceptor> authorizationInterceptorProvider;

  private final Provider<RefreshTokenInterceptor> refreshTokenInterceptorProvider;

  public MainActivity_MembersInjector(
      Provider<AuthorizationInterceptor> authorizationInterceptorProvider,
      Provider<RefreshTokenInterceptor> refreshTokenInterceptorProvider) {
    this.authorizationInterceptorProvider = authorizationInterceptorProvider;
    this.refreshTokenInterceptorProvider = refreshTokenInterceptorProvider;
  }

  public static MembersInjector<MainActivity> create(
      Provider<AuthorizationInterceptor> authorizationInterceptorProvider,
      Provider<RefreshTokenInterceptor> refreshTokenInterceptorProvider) {
    return new MainActivity_MembersInjector(authorizationInterceptorProvider, refreshTokenInterceptorProvider);
  }

  @Override
  public void injectMembers(MainActivity instance) {
    injectAuthorizationInterceptor(instance, authorizationInterceptorProvider.get());
    injectRefreshTokenInterceptor(instance, refreshTokenInterceptorProvider.get());
  }

  @InjectedFieldSignature("al.viki.ui.main.MainActivity.authorizationInterceptor")
  public static void injectAuthorizationInterceptor(MainActivity instance,
      AuthorizationInterceptor authorizationInterceptor) {
    instance.authorizationInterceptor = authorizationInterceptor;
  }

  @InjectedFieldSignature("al.viki.ui.main.MainActivity.refreshTokenInterceptor")
  public static void injectRefreshTokenInterceptor(MainActivity instance,
      RefreshTokenInterceptor refreshTokenInterceptor) {
    instance.refreshTokenInterceptor = refreshTokenInterceptor;
  }
}
