dependencies {
    // 引入 API
    compileOnly(project(":project:core"))
    compileOnly("net.md_5.bungee:BungeeCord:1")
}

// 子模块
taboolib { subproject = true }
