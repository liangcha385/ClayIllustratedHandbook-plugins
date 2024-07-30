repositories {
    maven { url = uri("https://repo.papermc.io/repository/maven-public/") }
}

dependencies {
    // 引入 API
    compileOnly(project(":project:core"))
    compileOnly("com.velocitypowered:velocity-api:3.1.1")
}

// 子模块
taboolib { subproject = true }
