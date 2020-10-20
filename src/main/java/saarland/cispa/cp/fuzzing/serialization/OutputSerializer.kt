package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File


object OutputSerializer {
    fun serialize(file: File, data: List<FuzzingResult>) {
        val jsonString = Json.encodeToString(ListSerializer(FuzzingResult.serializer()), data)
        file.writeText(jsonString)
    }
}