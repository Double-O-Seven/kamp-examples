dependencies {
    val kampVersion: String by rootProject.extra
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-streamer", version = kampVersion)
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-geodata", version = kampVersion)
}

plugins {
    id("ch.leadrian.samp.kamp.kamp-server-starter") version "1.0.0-rc3"
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.streamertest.StreamerTestGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
    configProperty("kamp.streamer.rate.ms", "300")
}
