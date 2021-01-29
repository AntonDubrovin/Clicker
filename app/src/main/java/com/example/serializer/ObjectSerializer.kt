@file:Suppress("UNCHECKED_CAST")

package com.example.serializer

import java.io.*

object ObjectSerializer {

    fun <T : Serializable> serialize(obj: T?): String {
        if (obj == null) {
            return ""
        }

        val baos = ByteArrayOutputStream()
        val oos = ObjectOutputStream(baos)
        oos.writeObject(obj)
        oos.close()

        return baos.toString("ISO-8859-1")
    }

    private fun <T : Serializable> deserialize(string: String): T? {
        if (string.isEmpty()) {
            return null
        }

        val bais = ByteArrayInputStream(string.toByteArray(charset("ISO-8859-1")))
        val ois = ObjectInputStream(bais)

        return ois.readObject() as T
    }

    fun <T : Serializable> deserialize(string: String, clazz: Class<T>): T? = deserialize<T>(string)

}