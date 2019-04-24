[![Build Status](https://travis-ci.org/Double-O-Seven/kamp-examples.svg?branch=master)](https://travis-ci.org/Double-O-Seven/kamp-examples)

# Kamp examples gamemodes

 Several examples for implementation an SA-MP gamemode using the Kotlin API provided by Kamp:

   * LVDM - a simple Las Venturas based gamemode that can be used as base for further development
   * AMX Interop Test - a gamemode demonstrating how to manually add additional native methods and callbacks from other native plugins
   * Hooks - a gamemode demonstrating how to hook SA-MP native functions on the lowest level, for an anti-cheat tool for example
   * Streamer Test - a gamemode demonstrating the capabilities of the streamer that comes as part of the extended Kamp API
   * FCNPC Test - a gamemode demonstrating the FCNPC wrapper
 
The gamemode Gradle projects also demonstrate how to use [kamp-server-starter](https://github.com/Double-O-Seven/kamp-server-starter) to automatically configure and start a server and [kamp-textkey-generator](https://github.com/Double-O-Seven/kamp-textkey-generator) to generate TextKeys from `string_<Locale>.properties` files.

Start a server with an example gamemode
---------------------------------------

To start a server for LVDM for example, simply use:

    ./gradlew :lvdm:startServer
    
To only configure the server --- for example for copying it somewhere else --- use:

    ./gradlew :lvdm:configureServer
    
The resulting server directory setup will be in the Gradle build directory of the gamemode project, `lvdm/build/samp-server` for example.
