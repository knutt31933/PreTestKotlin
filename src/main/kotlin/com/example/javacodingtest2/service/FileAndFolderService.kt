package com.example.javacodingtest2.service

import com.example.javacodingtest2.model.Folder
import net.minidev.json.JSONArray

class FileAndFolderService {
    fun createFileAndFolderFromJson(jsonArray: JSONArray): Folder? {
        // TODO: 1. complete this function. Parse JsonArray to Folder object
        return null
    }

    fun getMaxDepth(folder: Folder): Int {
        // TODO: 2. Find max depth of tree?
        return 0
    }

    fun validateFolderFromJson(jsonArray: JSONArray): Boolean? {
        // TODO: 3. Validate if file doesn't have child node
        return null
    }
}
