package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File

object FuzzingDataSerializer {
    fun serialize(fuzzingData: List<FuzzingData>): String {
        return Json.encodeToString(ListSerializer(FuzzingData.serializer()), fuzzingData)
    }

    fun serialize(filePath: String, fuzzingData: List<FuzzingData>) {
        val jsonString = serialize(fuzzingData)
        File(filePath).writeText(jsonString)
    }

    fun deserialize(jsonString: String): List<FuzzingData> {
        return Json.decodeFromString(ListSerializer(FuzzingData.serializer()), jsonString)
    }
}