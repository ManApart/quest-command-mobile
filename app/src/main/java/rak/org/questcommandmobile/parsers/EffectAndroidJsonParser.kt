package rak.org.questcommandmobile.parsers

import android.content.res.AssetManager
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import core.gameState.Effect
import core.utility.JsonDirectoryParser
import core.utility.NameSearchableList
import status.effects.EffectParser
import java.io.InputStreamReader

class EffectAndroidParser(private val assets: AssetManager) : EffectParser {
    private fun parseFile(path: String): List<Effect> = jacksonObjectMapper().readValue(InputStreamReader(assets.open(path)))

    override fun loadEffects(): NameSearchableList<Effect> {
        return NameSearchableList(JsonDirectoryParser.parseDirectory("/data/generated/content/effects", ::parseFile))
    }
}