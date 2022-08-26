package al.viki.ui.account;

import al.bruno.core.data.source.AuthorityRepository;
import al.bruno.core.data.source.RequestAccountRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class RequestNewAccountViewModel_Factory implements Factory<RequestNewAccountViewModel> {
  private final Provider<AuthorityRepository> authorityRepositoryProvider;

  private final Provider<RequestAccountRepository> requestAccountRepositoryProvider;

  public RequestNewAccountViewModel_Factory(
      Provider<AuthorityRepository> authorityRepositoryProvider,
      Provider<RequestAccountRepository> requestAccountRepositoryProvider) {
    this.authorityRepositoryProvider = authorityRepositoryProvider;
    this.requestAccountRepositoryProvider = requestAccountRepositoryProvider;
  }

  @Override
  public RequestNewAccountViewModel get() {
    return newInstance(authorityRepositoryProvider.get(), requestAccountRepositoryProvider.get());
  }

  public static RequestNewAccountViewModel_Factory create(
      Provider<AuthorityRepository> authorityRepositoryProvider,
      Provider<RequestAccountRepository> requestAccountRepositoryProvider) {
    return new RequestNewAccountViewModel_Factory(authorityRepositoryProvider, requestAccountRepositoryProvider);
  }

  public static RequestNewAccountViewModel newInstance(AuthorityRepository authorityRepository,
      RequestAccountRepository requestAccountRepository) {
    return new RequestNewAccountViewModel(authorityRepository, requestAccountRepository);
  }
}
