# multi-module-test

`master` branch implements multi module with dagger.

`hilt` branch tries to implements multi module with hilt-dagger with `EntryPointAccessors`.

Steps:

- [ ] My first step is to convert all component & subcomponent to `@EntryPoint` & then use it via `EntryPointAccessors` by
      providing required scoping to `ActivityComponent` or `FragmentComponent`.

- [ ] Remove the component & scope module to hilt's Activity or Fragment Component.
