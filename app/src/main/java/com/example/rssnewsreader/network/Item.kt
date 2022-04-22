package com.example.rssnewsreader.network

import org.simpleframework.xml.*

@Root(name = "item", strict = false)
data class Item(
    @field:Element(name = "title")
    var title: String = "",
    @field:Element(name = "guid")
    var guid: Guid = Guid(),
    @field:ElementList(inline = true, name = "description")
    @Path("rss/channel/item")
    var description: List<Description> = ArrayList(),
    @field:Element(name = "content", required = false)
    var img: Image = Image()
)
