plugins {
    id("kamp-server-starter")
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.hooks.HooksGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
}
