package ch.leadrian.samp.kamp.examples.fcnpctest

import ch.leadrian.samp.kamp.core.api.command.Commands
import ch.leadrian.samp.kamp.core.api.command.annotation.Command
import ch.leadrian.samp.kamp.core.api.command.annotation.Unlisted
import ch.leadrian.samp.kamp.core.api.constants.SkinModel
import ch.leadrian.samp.kamp.core.api.data.Colors
import ch.leadrian.samp.kamp.core.api.entity.Player
import ch.leadrian.samp.kamp.core.api.service.DialogService
import ch.leadrian.samp.kamp.core.api.text.MessageSender
import ch.leadrian.samp.kamp.core.api.util.logger
import ch.leadrian.samp.kamp.fcnpcwrapper.entity.FullyControllableNPC
import ch.leadrian.samp.kamp.fcnpcwrapper.service.FCNPCService
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class FCNPCTestCommands
@Inject
constructor(
        private val fcnpcService: FCNPCService,
        private val dialogService: DialogService,
        private val messageSender: MessageSender
) : Commands() {

    companion object {

        val log = logger()

    }

    private val random = Random(System.currentTimeMillis())

    @Unlisted
    @Command(name = "cmds", aliases = ["commands"])
    fun showCommands(player: Player) {
        showCommandList(player)
    }

    @Command
    fun fcnpcVersion(player: Player) {
        val version = fcnpcService.getPluginVersion()
        messageSender.sendMessageToPlayer(player, Colors.WHITE, "FCNPC version: $version")
    }

    @Command
    fun spawnNPC(player: Player, name: String) {
        val skinModels = SkinModel.values()
        val skinModel = skinModels[random.nextInt(skinModels.size)]
        val coordinates = player.coordinates.toMutableVector3D().apply {
            x += 1
            z += 1
        }
        val npc = fcnpcService.createNPC(name)
        npc.extensions.install(NPCCombatState.Factory)
        npc.spawn(skinModel, coordinates)
    }

    @Command
    fun npcs(player: Player) {
        val dialog = dialogService.createListDialog<FullyControllableNPC> {
            caption("NPCs")
            fcnpcService.getAllNPCs().forEach { npc ->
                item {
                    value(npc)
                    content(npc.name)
                }
            }
            onSelectItem { _, listDialogItem, _ ->
                player.coordinates = listDialogItem.value.coordinates.toMutableVector3D().apply { z += 2f }
            }
        }
        player.dialogNavigation.push(dialog)
    }
}