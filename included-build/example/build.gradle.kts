plugins {
    kotlin("jvm") 
    kotlin("kapt") 
}

dependencies {
    api("com.squareup.moshi:moshi:1.13.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.13.0")
}
