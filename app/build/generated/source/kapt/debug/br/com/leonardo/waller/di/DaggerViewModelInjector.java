// Generated by Dagger (https://google.github.io/dagger).
package br.com.leonardo.waller.di;

import br.com.leonardo.core.di.network.NetworkModule;
import br.com.leonardo.waller.di.module.RepositoryModule;
import br.com.leonardo.waller.di.module.RepositoryModule_ProvidesUnplashRepositoryFactory;
import br.com.leonardo.waller.model.dataManager.UnplashRepository;
import br.com.leonardo.waller.presenter.MainWallViewModel;
import br.com.leonardo.waller.presenter.MainWallViewModel_MembersInjector;
import dagger.internal.DoubleCheck;
import dagger.internal.Preconditions;
import javax.inject.Provider;

public final class DaggerViewModelInjector implements ViewModelInjector {
  private Provider<UnplashRepository> providesUnplashRepositoryProvider;

  private DaggerViewModelInjector(RepositoryModule repositoryModuleParam) {

    initialize(repositoryModuleParam);
  }

  public static ViewModelInjector.Builder builder() {
    return new Builder();
  }

  @SuppressWarnings("unchecked")
  private void initialize(final RepositoryModule repositoryModuleParam) {
    this.providesUnplashRepositoryProvider =
        DoubleCheck.provider(
            RepositoryModule_ProvidesUnplashRepositoryFactory.create(repositoryModuleParam));
  }

  @Override
  public void inject(MainWallViewModel viewModel) {
    injectMainWallViewModel(viewModel);
  }

  private MainWallViewModel injectMainWallViewModel(MainWallViewModel instance) {
    MainWallViewModel_MembersInjector.injectUnplashRepository(
        instance, providesUnplashRepositoryProvider.get());
    return instance;
  }

  private static final class Builder implements ViewModelInjector.Builder {
    private RepositoryModule repositoryModule;

    /**
     * @deprecated This module is declared, but an instance is not used in the component. This
     *     method is a no-op. For more, see https://google.github.io/dagger/unused-modules.
     */
    @Override
    @Deprecated
    public Builder networkModule(NetworkModule networkModule) {
      Preconditions.checkNotNull(networkModule);
      return this;
    }

    @Override
    public Builder repositoryModule(RepositoryModule repositoryModule) {
      this.repositoryModule = Preconditions.checkNotNull(repositoryModule);
      return this;
    }

    @Override
    public ViewModelInjector build() {
      Preconditions.checkBuilderRequirement(repositoryModule, RepositoryModule.class);
      return new DaggerViewModelInjector(repositoryModule);
    }
  }
}