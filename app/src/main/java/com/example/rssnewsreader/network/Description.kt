package com.example.rssnewsreader.network

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root(name = "description", strict = false)
data class Description(
    @field:Text(required = false)
    var description: String = ""
)
