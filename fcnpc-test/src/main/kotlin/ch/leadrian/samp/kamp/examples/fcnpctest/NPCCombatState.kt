package ch.leadrian.samp.kamp.examples.fcnpctest

import ch.leadrian.samp.kamp.fcnpcwrapper.entity.FullyControllableNPC
import ch.leadrian.samp.kamp.fcnpcwrapper.entity.HasFullyControllableNPC

class NPCCombatState(override val npc: FullyControllableNPC) : HasFullyControllableNPC {

    var isAggressive: Boolean = false

}

val FullyControllableNPC.combatState: NPCCombatState
    get() = extensions.get()
