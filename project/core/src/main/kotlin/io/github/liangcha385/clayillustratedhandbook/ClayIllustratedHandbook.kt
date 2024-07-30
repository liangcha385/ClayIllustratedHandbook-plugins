package io.github.liangcha385.clayillustratedhandbook

import taboolib.module.configuration.Config
import taboolib.module.configuration.Configuration

object ClayIllustratedHandbook {
    @Config
    lateinit var conf: Configuration
        private set
}