# training-OBWK

## About Basic pokedex

This project contains 6 microservices 

* pokedex-config-server (Configurations file can be found : https://github.com/nathalysalamanca/pokedex-config-server.git)
* api-gateway
* discovery-server
* pokedex-info
* pokedex-strategy
* pokedex-tabletypes


Through the api-gateway the application exposes 3 APIs 
* http://localhost:8080/api/pokedex/info 
* http://localhost:8080/api/pokedex/type
* http://localhost:8080/api/pokedex/strategy

## pokedex info
### Endpoint 
* http://localhost:8080/api/pokedex/info 
### Request
```
{
    "name":"onix";
}
```
###Response
```

{
    "id": "95",
    "name": "onix",
    "types": [
        "rock",
        "ground"
    ],
    "descriptionItems": [
        {
            "descriptionText": "As it grows, the\nstone portions of\nits body harden\fto become similar\nto a diamond, but\ncolored black.",
            "gameVersion": "red",
            "languageCode": "en"
        }
    ]
}

```

## pokedex type
### Endpoint
* http://localhost:8080/api/pokedex/tyoe
### Request
```
{
    "name":"fire";
}
```
###Response
```

{
    "id": "10",
    "name": "fire",
    "weaknesses": [
        {
            "name": "ground",
            "damage": "Double"
        },
        {
            "name": "fairy",
            "damage": "Half"
        }
    ]
}
```
## pokedex strategy
### Endpoint
* http://localhost:8080/api/pokedex/strategy
### Request
```
{
    "name":"onix";
}
```
###Response
```

{
    "id": "95",
    "name": "onix",
    "typeWeaknesses": [
        {
            "type": "rock",
            "weaknessesList": [
                {
                    "name": "fighting",
                    "damage": "Double"
                },
                {
                    "name": "ground",
                    "damage": "Double"
                }
            ]
        },
        {
            "type": "ground",
            "weaknessesList": [
                {
                    "name": "water",
                    "damage": "Double"
                } 
            ]
        }
    ]
}
```

## Working with Basic pokedex in your IDE

### Prerequisites
The following items should be installed in your system:
* Java 11 or newer (full JDK not a JRE).
* git command line tool (https://help.github.com/articles/set-up-git)
* Your preferred IDE 
  * Eclipse with the m2e plugin. Note: when m2e is available, there is an m2 icon in `Help -> About` dialog. If m2e is
  not there, just follow the install process here: https://www.eclipse.org/m2e/
  * [Spring Tools Suite](https://spring.io/tools) (STS)
  * IntelliJ IDEA
  * [VS Code](https://code.visualstudio.com)

### Steps:

1) On the command line
    ```
    git clone https://github.com/nathalysalamanca/training-OBWK.git
    ```
2) Inside Eclipse or STS
    ```
    File -> Import -> Maven -> Existing Maven project 
    ```
   Then select all six microservices
   Finally clean install and run every microservice in any order as long as pokedex-config-server and discovery-server are launched first

3) Inside IntelliJ IDE
    In the main menu, choose `File -> Open` and select the all microservices. Click on the `Open` button.
    Finally clean install and run every microservice in any order as long as pokedex-config-server and discovery-server are launched first
