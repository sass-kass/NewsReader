package com.example.rssnewsreader.network

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "rss", strict = false)
data class Feed(
    @field:Element(name = "channel")
    var channel: Channel = Channel()
)
