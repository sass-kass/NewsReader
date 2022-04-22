package com.example.rssnewsreader.network

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Path
import org.simpleframework.xml.Root
import retrofit2.http.Url

@Root(name = "content", strict = false)
data class Image(
    @field:Attribute(name = "url")
    var img: String = ""
)
