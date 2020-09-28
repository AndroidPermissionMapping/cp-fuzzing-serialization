package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.Serializable

sealed class FuzzingData

@Serializable
data class ResolverCallWithAuthority(
        val authority: String,
        val method: String,
        val arg: String?,
        val extras: Map<String, String>?
)

@Serializable
data class ResolverCallUri(
        val uri: String,
        val method: String,
        val arg: String?,
        val extras: Map<String, String>?
)

data class ResolverQuery(
        val uri: String,
        val projection: Array<String>,
        val queryArgs: Map<String, String>
) : FuzzingData() {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}

data class ResolverInsert(
        val uri: String,
        val contentValues: Map<String, String>?
) : FuzzingData()

data class ResolverUpdate(
        val uri: String,
        val contentValues: Map<String, String>?,
        val where: String?,
        val selectionArgs: Array<String>?
) : FuzzingData() {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}


data class ResolverDelete(
        val uri: String,
        val where: String?,
        val selectionArgs: Array<String>?
) : FuzzingData() {
    override fun equals(other: Any?): Boolean {
        return super.equals(other)
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }
}