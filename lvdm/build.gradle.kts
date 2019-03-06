dependencies {
    val kampVersion: String by rootProject.extra
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-common", version = kampVersion)
}

plugins {
    id("kamp-textkey-generator")
    id("kamp-server-starter")
}

textKeyGenerator {
    className = "LvdmTextKeys"
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.lvdm.LvdmGameMode"
    rconPassword = "test1234"
    jvmOption("-Xmx1G")
    configProperty("lvdm.respawn.cash.amount", "2500")
}
