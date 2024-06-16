package com.rbs.firstapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform