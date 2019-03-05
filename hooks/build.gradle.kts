plugins {
    id("kamp-serverstarter")
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.hooks.HooksGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
}
