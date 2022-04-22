package com.example.rssnewsreader.network

import org.simpleframework.xml.ElementList
import org.simpleframework.xml.Root

@Root(name = "channel", strict = false)
data class Channel(
    @field:ElementList(inline = true, required = false)
    var itemList: List<Item> = ArrayList()
)
