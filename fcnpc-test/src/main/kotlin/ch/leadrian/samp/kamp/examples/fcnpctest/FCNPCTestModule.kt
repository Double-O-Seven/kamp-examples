package ch.leadrian.samp.kamp.examples.fcnpctest

import ch.leadrian.samp.kamp.core.api.inject.KampModule

class FCNPCTestModule : KampModule() {

    override fun configure() {
        bind(PlayerSpawner::class.java).asEagerSingleton()
        bind(PlayerClassSelector::class.java).asEagerSingleton()
        bind(NPCController::class.java).asEagerSingleton()
        newCommandsSetBinder().apply {
            addBinding().to(FCNPCTestCommands::class.java)
        }
    }
}