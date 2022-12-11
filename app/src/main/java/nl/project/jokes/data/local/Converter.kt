package nl.project.jokes.data.local

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import nl.project.jokes.model.Flags

class Converter {
    @TypeConverter
    fun fromToString(flags: Flags): String {
        return Json.encodeToString(flags)
    }

    @TypeConverter
    fun fromFlagsToString(string: String): Flags {
        return Json.decodeFromString(string)
    }
}