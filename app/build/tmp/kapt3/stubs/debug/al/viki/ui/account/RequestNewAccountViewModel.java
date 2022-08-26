package al.viki.ui.account;

import java.lang.System;

@dagger.hilt.android.lifecycle.HiltViewModel()
@kotlin.Metadata(mv = {1, 7, 1}, k = 1, d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u000f\u001a\u00020\u001aH\u0002J0\u0010\u001b\u001a\u00020\u001a2\f\u0010\u001c\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0016J\u0016\u0010$\u001a\u00020\u001a2\f\u0010%\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001dH\u0016J\u0006\u0010&\u001a\u00020\u001aR \u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R#\u0010\u000f\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0019\u0010\u0014\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001d\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\n0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\'"}, d2 = {"Lal/viki/ui/account/RequestNewAccountViewModel;", "Landroidx/lifecycle/ViewModel;", "Landroid/widget/AdapterView$OnItemSelectedListener;", "authorityRepository", "Lal/bruno/core/data/source/AuthorityRepository;", "requestAccountRepository", "Lal/bruno/core/data/source/RequestAccountRepository;", "(Lal/bruno/core/data/source/AuthorityRepository;Lal/bruno/core/data/source/RequestAccountRepository;)V", "_authorities", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lal/bruno/core/State;", "", "Lal/viki/model/AuthorityUi;", "_request", "", "authorities", "Lkotlinx/coroutines/flow/StateFlow;", "getAuthorities", "()Lkotlinx/coroutines/flow/StateFlow;", "authorityUi", "email", "", "getEmail", "()Lkotlinx/coroutines/flow/MutableStateFlow;", "request", "getRequest", "", "onItemSelected", "adapterView", "Landroid/widget/AdapterView;", "view", "Landroid/view/View;", "position", "", "p3", "", "onNothingSelected", "p0", "requestNewAccount", "app_debug"})
public final class RequestNewAccountViewModel extends androidx.lifecycle.ViewModel implements android.widget.AdapterView.OnItemSelectedListener {
    private final al.bruno.core.data.source.AuthorityRepository authorityRepository = null;
    private final al.bruno.core.data.source.RequestAccountRepository requestAccountRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> email = null;
    private al.viki.model.AuthorityUi authorityUi;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.lang.Boolean>> _request = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Boolean>> request = null;
    private final kotlinx.coroutines.flow.MutableStateFlow<al.bruno.core.State<java.util.List<al.viki.model.AuthorityUi>>> _authorities = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.AuthorityUi>>> authorities = null;
    
    @javax.inject.Inject()
    public RequestNewAccountViewModel(@org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.AuthorityRepository authorityRepository, @org.jetbrains.annotations.NotNull()
    al.bruno.core.data.source.RequestAccountRepository requestAccountRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.MutableStateFlow<java.lang.String> getEmail() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.lang.Boolean>> getRequest() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<al.bruno.core.State<java.util.List<al.viki.model.AuthorityUi>>> getAuthorities() {
        return null;
    }
    
    private final void authorities() {
    }
    
    public final void requestNewAccount() {
    }
    
    @java.lang.Override()
    public void onItemSelected(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> adapterView, @org.jetbrains.annotations.Nullable()
    android.view.View view, int position, long p3) {
    }
    
    @java.lang.Override()
    public void onNothingSelected(@org.jetbrains.annotations.Nullable()
    android.widget.AdapterView<?> p0) {
    }
}