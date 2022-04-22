package com.example.rssnewsreader.network

import org.simpleframework.xml.Attribute
import org.simpleframework.xml.Root
import org.simpleframework.xml.Text

@Root( name = "guid")
data class Guid(
    @field:Attribute(name = "isPermaLink", required = false)
    var isPermaLink: Boolean = false,
    @field:Text(required = false)
    var link: String = ""
)
