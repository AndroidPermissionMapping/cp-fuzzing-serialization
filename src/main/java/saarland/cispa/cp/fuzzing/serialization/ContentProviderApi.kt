package saarland.cispa.cp.fuzzing.serialization

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FuzzingData(val className: String, val data: List<ContentProviderApi>)

@Serializable
sealed class ContentProviderApi {
    abstract val uri: String
}

@Serializable
data class ContentValue(val typeName: String, val key: String)

@Serializable
@SerialName("insert_api_1")
data class ResolverCallInsert(
        override val uri: String,
        val contentValue: ContentValue
) : ContentProviderApi()

@Serializable
@SerialName("call")
data class ResolverCallUri(
        override val uri: String,
        val method: String,
        val arg: String?,
        val extras: Map<String, String>?
) : ContentProviderApi()

@Serializable
@SerialName("query_api_1")
data class ResolverQueryApi1(
        override val uri: String,
        val projection: Array<String>?,
        val selection: String?,
        val selectionArgs: Array<String>?,
        val sortOrder: String?
) : ContentProviderApi() {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ResolverQueryApi1

        if (uri != other.uri) return false
        if (projection != null) {
            if (other.projection == null) return false
            if (!projection.contentEquals(other.projection)) return false
        } else if (other.projection != null) return false
        if (selection != other.selection) return false
        if (selectionArgs != null) {
            if (other.selectionArgs == null) return false
            if (!selectionArgs.contentEquals(other.selectionArgs)) return false
        } else if (other.selectionArgs != null) return false
        if (sortOrder != other.sortOrder) return false

        return true
    }

    override fun hashCode(): Int {
        var result = uri.hashCode()
        result = 31 * result + (projection?.contentHashCode() ?: 0)
        result = 31 * result + (selection?.hashCode() ?: 0)
        result = 31 * result + (selectionArgs?.contentHashCode() ?: 0)
        result = 31 * result + (sortOrder?.hashCode() ?: 0)
        return result
    }
}