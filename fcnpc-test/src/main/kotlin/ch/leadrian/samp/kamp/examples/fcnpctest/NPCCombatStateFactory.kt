package ch.leadrian.samp.kamp.examples.fcnpctest

import ch.leadrian.samp.kamp.core.api.entity.extension.EntityExtensionFactory
import ch.leadrian.samp.kamp.fcnpcwrapper.entity.FullyControllableNPC
import javax.inject.Inject
import kotlin.reflect.KClass

class NPCCombatStateFactory
@Inject
constructor() : EntityExtensionFactory<FullyControllableNPC, NPCCombatState> {

    override val extensionClass: KClass<NPCCombatState> = NPCCombatState::class

    override fun create(entity: FullyControllableNPC): NPCCombatState = NPCCombatState(entity)

}