dependencies {
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-core", version = "1.0.0-rc1")
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-view", version = "1.0.0-rc1")
    implementation(group = "org.slf4j", name = "slf4j-log4j12", version = "1.7.25")
}

plugins {
    id("kamp-server-starter")
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.viewtest.ViewTestGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
}
