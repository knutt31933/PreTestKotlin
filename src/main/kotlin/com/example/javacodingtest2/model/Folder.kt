package com.example.javacodingtest2.model

class Folder : Node() {
    var parentFolder: Folder? = null

    var childen: MutableList<Node>? = null
}
