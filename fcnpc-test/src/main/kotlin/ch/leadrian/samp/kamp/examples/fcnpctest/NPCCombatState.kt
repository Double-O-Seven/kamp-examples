package ch.leadrian.samp.kamp.examples.fcnpctest

import ch.leadrian.samp.kamp.core.api.entity.extension.EntityExtensionFactory
import ch.leadrian.samp.kamp.fcnpcwrapper.entity.FullyControllableNPC
import ch.leadrian.samp.kamp.fcnpcwrapper.entity.HasFullyControllableNPC
import kotlin.reflect.KClass

class NPCCombatState(override val npc: FullyControllableNPC) : HasFullyControllableNPC {

    var isAggressive: Boolean = false

    object Factory : EntityExtensionFactory<FullyControllableNPC, NPCCombatState> {

        override val extensionClass: KClass<NPCCombatState> = NPCCombatState::class

        override fun create(entity: FullyControllableNPC): NPCCombatState = NPCCombatState(entity)

    }

}

val FullyControllableNPC.combatState: NPCCombatState
    get() = extensions.get()
