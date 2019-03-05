dependencies {
    val kampVersion: String by rootProject.extra
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-streamer", version = kampVersion)
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-geodata", version = kampVersion)
}

plugins {
    id("kamp-server-starter")
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.streamertest.StreamerTestGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
    configProperty("kamp.streamer.rate.ms", "300")
}
