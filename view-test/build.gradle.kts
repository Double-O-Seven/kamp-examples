dependencies {
    val kampVersion: String by rootProject.extra
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-core", version = kampVersion)
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-view", version = kampVersion)
    implementation(group = "org.slf4j", name = "slf4j-log4j12", version = "1.7.25")
}

plugins {
    id("ch.leadrian.samp.kamp.kamp-server-starter") version "1.0.0-rc4"
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.viewtest.ViewTestGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
}
