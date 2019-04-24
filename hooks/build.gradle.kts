plugins {
    id("ch.leadrian.samp.kamp.kamp-server-starter") version "1.0.0-rc3"
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.hooks.HooksGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
}
