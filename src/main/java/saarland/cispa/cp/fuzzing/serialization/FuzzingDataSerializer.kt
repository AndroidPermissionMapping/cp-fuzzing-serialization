package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File

object FuzzingDataSerializer {
    fun serialize(filePath: String, callUris: List<ResolverCallUri>) {
        val jsonString = Json.encodeToString(ListSerializer(ResolverCallUri.serializer()), callUris)
        File(filePath).writeText(jsonString)
    }

    fun deserialize(file: File): List<ResolverCallUri> {
        val jsonString = file.readText()
        return Json.decodeFromString(ListSerializer(ResolverCallUri.serializer()), jsonString)
    }
}