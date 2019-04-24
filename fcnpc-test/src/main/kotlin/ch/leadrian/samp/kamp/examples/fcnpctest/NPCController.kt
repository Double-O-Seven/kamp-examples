package ch.leadrian.samp.kamp.examples.fcnpctest

import ch.leadrian.samp.kamp.core.api.callback.CallbackListenerManager
import ch.leadrian.samp.kamp.core.api.constants.BodyPart
import ch.leadrian.samp.kamp.core.api.constants.WeaponModel
import ch.leadrian.samp.kamp.core.api.entity.Player
import ch.leadrian.samp.kamp.core.api.service.PlayerService
import ch.leadrian.samp.kamp.core.api.timer.TimerExecutor
import ch.leadrian.samp.kamp.core.api.util.logger
import ch.leadrian.samp.kamp.fcnpcwrapper.callback.OnNPCCreateListener
import ch.leadrian.samp.kamp.fcnpcwrapper.callback.OnNPCDeathListener
import ch.leadrian.samp.kamp.fcnpcwrapper.callback.OnNPCSpawnListener
import ch.leadrian.samp.kamp.fcnpcwrapper.callback.OnNPCTakeDamageListener
import ch.leadrian.samp.kamp.fcnpcwrapper.data.AimParameters
import ch.leadrian.samp.kamp.fcnpcwrapper.entity.FullyControllableNPC
import ch.leadrian.samp.kamp.fcnpcwrapper.entity.id.FullyControllableNPCId
import ch.leadrian.samp.kamp.fcnpcwrapper.service.FCNPCService
import java.util.concurrent.TimeUnit
import javax.annotation.PostConstruct
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NPCController
@Inject
constructor(
        private val timerExecutor: TimerExecutor,
        private val fcnpcService: FCNPCService,
        private val callbackListenerManager: CallbackListenerManager,
        private val playerService: PlayerService
) : OnNPCCreateListener, OnNPCSpawnListener, OnNPCTakeDamageListener, OnNPCDeathListener {

    companion object {

        private val log = logger()

    }

    @PostConstruct
    fun initialize() {
        callbackListenerManager.register(this)
        timerExecutor.addRepeatingTimer(4, TimeUnit.SECONDS) {
            attackClosestPlayer()
        }
    }

    private fun attackClosestPlayer() {
        fcnpcService.getAllNPCs().asSequence().filter { it.combatState.isAggressive }.forEach { npc ->
            val coordinates = npc.coordinates
            playerService
                    .getAllPlayers()
                    .asSequence()
                    .firstOrNull { it.isHuman && it.isInRange(coordinates, 20f) }
                    ?.let { npc.combat.aimAt(it, AimParameters(shoot = true)) }
        }
    }

    override fun onNPCTakeDamage(
            npc: FullyControllableNPC,
            issuer: Player?,
            amount: Float,
            weaponModel: WeaponModel,
            bodyPart: BodyPart
    ): OnNPCTakeDamageListener.Result {
        if (issuer != null) {
            npc.combatState.isAggressive = true
        }
        return OnNPCTakeDamageListener.Result.Allow
    }

    override fun onNPCCreate(npcId: FullyControllableNPCId) {
        log.info("NPC $npcId created")
    }

    override fun onNPCSpawn(npc: FullyControllableNPC) {
        npc.apply {
            weapons.current = WeaponModel.SHOTGUN
            weapons.ammo = 9999
        }
    }

    override fun onNPCDeath(npc: FullyControllableNPC, killer: Player?, reason: WeaponModel) {
        npc.combatState.isAggressive = false
        timerExecutor.addTimer(3, TimeUnit.SECONDS) {
            npc.respawn()
        }
    }

}