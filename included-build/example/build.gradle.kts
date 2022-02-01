plugins {
    kotlin("jvm") version "1.6.10"
    kotlin("kapt") version "1.6.10"
}

dependencies {
    api("com.squareup.moshi:moshi:1.13.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")
}
