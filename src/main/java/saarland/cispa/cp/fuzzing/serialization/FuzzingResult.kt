package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.Serializable


@Serializable
data class FuzzingResult(
    val input: ContentProviderApi,
    val thrownException: String?,
)