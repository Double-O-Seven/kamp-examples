dependencies {
    val kampVersion: String by rootProject.extra
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-common", version = kampVersion)
}

plugins {
    id("ch.leadrian.samp.kamp.kamp-textkey-generator") version "1.0.0-rc2"
    id("ch.leadrian.samp.kamp.kamp-server-starter") version "1.0.0-rc4"
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
