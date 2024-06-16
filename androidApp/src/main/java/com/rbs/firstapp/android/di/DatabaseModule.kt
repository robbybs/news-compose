package com.rbs.firstapp.android.di

import app.cash.sqldelight.db.SqlDriver
import com.rbs.firstapp.db.AppDatabase
import com.rbs.firstapp.db.DatabaseDriverFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val databaseModule = module {
    single<SqlDriver> { DatabaseDriverFactory(androidContext()).createDriver() }
    single<AppDatabase> { AppDatabase(get()) }
}