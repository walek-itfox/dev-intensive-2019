package ru.skillbranch.devintensive.utils

object Utils {
    fun parseFullName(fullName: String?): Pair<String?, String?> {
        val parts: List<String>? = fullName?.split(" ")

        val firstName = parts?.getOrNull(0)
        val lastName = parts?.getOrNull(1)

        return Pair(firstName, lastName)
    }

    fun transliteration(fullname: String, divider: String = " "): String {
        val simbols = mapOf(
            "а" to "a",
            "б" to "b",
            "в" to "v",
            "г" to "g",
            "д" to "d",
            "е" to "e",
            "ё" to "e",
            "ж" to "zh",
            "з" to "z",
            "и" to "i",
            "й" to "i",
            "к" to "k",
            "л" to "l",
            "м" to "m",
            "н" to "n",
            "о" to "o",
            "п" to "p",
            "р" to "r",
            "с" to "s",
            "т" to "t",
            "у" to "u",
            "ф" to "f",
            "х" to "h",
            "ц" to "c",
            "ч" to "ch",
            "ш" to "sh",
            "щ" to "sh'",
            "ъ" to "",
            "ы" to "i",
            "ь" to "",
            "э" to "e",
            "ю" to "yu",
            "я" to "ya")

        var result = ""
        for(c in fullname) {
            if(c.toString() == " ") result += divider
            else if(simbols.containsKey(c.toString().toLowerCase())) result += simbols[c.toString().toLowerCase()]
            else result += c.toString()
        }

        val parts = result.split(divider)
        result = ""
        var i = 0
        for(word in parts) {
            i++
            result += word.capitalize()
            if (i < parts.size) result += divider
        }

        return result
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        if ((firstName == null && lastName == null) || (firstName == "" && lastName == "")) return null

        var initials = ""
        if (firstName != null) initials += firstName[0].toUpperCase()
        if (lastName != null) initials += lastName[0].toUpperCase()
        return initials
    }
}