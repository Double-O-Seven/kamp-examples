dependencies {
    implementation(group = "org.slf4j", name = "slf4j-log4j12", version = "1.7.25")
    implementation(group = "ch.leadrian.samp.kamp", name = "kamp-fcnpc-wrapper", version = "1.0.0-rc1")
}

plugins {
    id("ch.leadrian.samp.kamp.kamp-server-starter") version "1.0.0-rc4"
}

serverStarter {
    gameModeClassName = "ch.leadrian.samp.kamp.examples.fcnpctest.FCNPCTestGameMode"
    rconPassword = "test1234"
    maxNPCs = 10
    jvmOption("-Xmx1G")
    additionalWindowsPlugins(projectDir.resolve("plugins/FCNPC.dll"))
    additionalLinuxPlugins(projectDir.resolve("plugins/FCNPC.so"))
}

val copyScriptFiles by tasks.creating(Copy::class) {
    from(projectDir.resolve("scriptfiles"))
    into(buildDir.resolve("samp-server/scriptfiles"))
}

tasks {
    configureServer {
        finalizedBy(copyScriptFiles)
    }
}
