package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File


object FuzzingResultSerializer {
    fun toJson(data: FuzzingResult): String {
        return Json.encodeToString(FuzzingResult.serializer(), data)
    }

    fun toJson(data: List<FuzzingResult>): String {
        return Json.encodeToString(ListSerializer(FuzzingResult.serializer()), data)
    }
}