package al.viki.ui.main;

import java.lang.System;

@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0005\u00a2\u0006\u0002\u0010\u0003J\u0012\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u0017H\u0016R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002\u00a2\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015\u00a8\u0006\u001b"}, d2 = {"Lal/viki/ui/main/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lal/viki/authentication/auth/NotifyAuthenticationChange;", "()V", "authorizationInterceptor", "Lal/bruno/core/interceptor/AuthorizationInterceptor;", "getAuthorizationInterceptor", "()Lal/bruno/core/interceptor/AuthorizationInterceptor;", "setAuthorizationInterceptor", "(Lal/bruno/core/interceptor/AuthorizationInterceptor;)V", "mainViewModel", "Lal/viki/ui/main/MainViewModel;", "getMainViewModel", "()Lal/viki/ui/main/MainViewModel;", "mainViewModel$delegate", "Lkotlin/Lazy;", "refreshTokenInterceptor", "Lal/bruno/core/interceptor/RefreshTokenInterceptor;", "getRefreshTokenInterceptor", "()Lal/bruno/core/interceptor/RefreshTokenInterceptor;", "setRefreshTokenInterceptor", "(Lal/bruno/core/interceptor/RefreshTokenInterceptor;)V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "onSignOut", "app_debug"})
@dagger.hilt.android.AndroidEntryPoint()
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements al.viki.authentication.auth.NotifyAuthenticationChange {
    private final kotlin.Lazy mainViewModel$delegate = null;
    @javax.inject.Inject()
    public al.bruno.core.interceptor.AuthorizationInterceptor authorizationInterceptor;
    @javax.inject.Inject()
    public al.bruno.core.interceptor.RefreshTokenInterceptor refreshTokenInterceptor;
    
    public MainActivity() {
        super();
    }
    
    private final al.viki.ui.main.MainViewModel getMainViewModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final al.bruno.core.interceptor.AuthorizationInterceptor getAuthorizationInterceptor() {
        return null;
    }
    
    public final void setAuthorizationInterceptor(@org.jetbrains.annotations.NotNull()
    al.bruno.core.interceptor.AuthorizationInterceptor p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final al.bruno.core.interceptor.RefreshTokenInterceptor getRefreshTokenInterceptor() {
        return null;
    }
    
    public final void setRefreshTokenInterceptor(@org.jetbrains.annotations.NotNull()
    al.bruno.core.interceptor.RefreshTokenInterceptor p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    public void onSignOut() {
    }
}