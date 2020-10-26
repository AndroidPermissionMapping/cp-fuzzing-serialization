package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File

object FuzzingDataSerializer {
    fun serialize(filePath: String, fuzzingData: List<FuzzingData>) {
        val jsonString = Json.encodeToString(ListSerializer(FuzzingData.serializer()), fuzzingData)
        File(filePath).writeText(jsonString)
    }

    fun deserialize(file: File): List<FuzzingData> {
        val jsonString = file.readText()
        return Json.decodeFromString(ListSerializer(FuzzingData.serializer()), jsonString)
    }
}