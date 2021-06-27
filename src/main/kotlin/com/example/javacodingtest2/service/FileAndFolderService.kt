package com.example.javacodingtest2.service

import com.example.javacodingtest2.model.Folder
import com.example.javacodingtest2.model.Node
import com.example.javacodingtest2.model.TransferDataFromFile
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import net.minidev.json.JSONArray
import net.minidev.json.JSONObject

class FileAndFolderService {
    fun createFileAndFolderFromJson(jsonArray: JSONArray): Folder? {
        // TODO: 1. complete this function. Parse JsonArray to Folder object
        val folder = Folder()
        val fileTransfer = mutableListOf<TransferDataFromFile>()
        val nodeList = mutableListOf<Node>()

        jsonArray.forEachIndexed { index, _ ->
            val m: JSONObject = jsonArray[index] as JSONObject
            val id = m["id"] as Int
            val type = m["type"] as String
            val parentId = m["parentId"] as Int?

            if (parentId == null){
                folder.id = id
                folder.type = type
                folder.parentFolder = folder
            } else {
                val node = Node()
                node.id = id
                node.type = type
                node.parentId = parentId
                nodeList.add(node)
            }

        }

        folder.childen = nodeList

        return folder
    }

    fun getMaxDepth(folder: Folder): Int {
        // TODO: 2. Find max depth of tree?
        val folderRoot = folder.parentFolder?.id ?: 0
        var idRootTemp = mutableListOf<Int>(folderRoot)
        var findDeep: MutableList<Node>? = folder.childen
        var latestFile =  mutableListOf<Int>()
        var maxDeep = 0
        while (!findDeep.isNullOrEmpty()){
            println("idRootTemp : $idRootTemp")
            latestFile = idRootTemp
            findDeep.forEach {
                println("findDeep : id-${it.id} | type-${it.type} | parentId: ${it.parentId}")
            }
            val searchIdRoot = mutableListOf<Int>()
            findDeep.filter {
                idRootTemp.contains(it.parentId) && it.type == "folder"
            }.also {
                it.forEach {it
                    searchIdRoot.add(it.id)
                }
                idRootTemp = searchIdRoot
                findDeep.removeAll(it)
            }

            maxDeep+=1

            if (idRootTemp.isEmpty()){
                findDeep.find {
                    it.parentId == latestFile[0] && it.type == "file"
                }?.also {
                    maxDeep+=1
                }

                break
            }

        }
        println("max deep : $maxDeep")
        return maxDeep
    }

    fun validateFolderFromJson(jsonArray: JSONArray): Boolean? {
        // TODO: 3. Validate if file doesn't have child node
        return null
    }
}
