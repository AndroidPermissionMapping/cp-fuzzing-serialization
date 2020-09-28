package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.Serializable
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json
import java.io.File

@Serializable
data class FuzzingIOData(val api_type: String, val uri: String, val method: String)

