package com.kpstv.home.di

import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.migration.AliasOf
import javax.inject.Scope

@Scope
@AliasOf(FragmentScoped::class)
annotation class HomeScope
