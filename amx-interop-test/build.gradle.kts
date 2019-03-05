dependencies {
    val kampVersion: String by rootProject.extra
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-common", version = kampVersion)
}

plugins {
    id("kamp-serverstarter")
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.amxinteroptest.AmxInteropTestGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
}