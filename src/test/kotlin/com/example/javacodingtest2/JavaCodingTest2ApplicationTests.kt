package com.example.javacodingtest2

import com.example.javacodingtest2.service.FileAndFolderService
import net.minidev.json.JSONArray
import net.minidev.json.parser.JSONParser
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.core.io.Resource

@SpringBootTest
class JavaCodingTest2ApplicationTests {

    @Value("classpath:files1.json")
    lateinit var file1Resource: Resource

    @Value("classpath:files2.json")
    lateinit var file2Resource: Resource

    @Value("classpath:files3.json")
    lateinit var file3Resource: Resource

    @Test
    fun contextLoads() {
        val fileAndFolderService = FileAndFolderService()
        val folder = fileAndFolderService.createFileAndFolderFromJson((JSONParser().parse(file1Resource.inputStream) as JSONArray))

        //Assertions.assertNotNull(folder)
        Assertions.assertEquals(FileAndFolderService().getMaxDepth(folder!!), 7)

        val folder2 = fileAndFolderService.createFileAndFolderFromJson((JSONParser().parse(file2Resource.inputStream) as JSONArray))

        //Assertions.assertNotNull(folder2)
        Assertions.assertEquals(FileAndFolderService().getMaxDepth(folder2!!), 8)

//        Assertions.assertEquals(fileAndFolderService.validateFolderFromJson((JSONParser().parse(file2Resource.inputStream) as JSONArray)), true)
//        Assertions.assertEquals(fileAndFolderService.validateFolderFromJson((JSONParser().parse(file3Resource.inputStream) as JSONArray)), false)
    }
}
