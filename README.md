# Authentication
Endpoints for authentication

## End-point: DEMO
### GET /api/v1/demo

This endpoint retrieves the demo information.

#### Request

This request does not require a request body.

#### Response

The response is in plain text format and includes the following data:

- **Status**: 200
    
- **Content-Type**: text/plain
    

The response body includes the following information:

- **Bienvenido**: \[string\] - A welcome message
    
- **Correo**: \[string\] - The email address
    

``` json
{
    "Bienvenido": "anthony1",
    "Correo": "anthony.moroccoire.dev@gmail.com"
}

 ```
### Method: GET
>```
>undefined
>```
### 🔑 Authentication bearer

|Param|value|Type|
|---|---|---|
|token|{{token}}|



⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: LOGIN
### Auth Login

This endpoint allows users to authenticate and obtain a token for accessing protected resources.

#### Request Body

- email (string, required): The email address of the user.
    
- password (string, required): The password of the user.
    

#### Response

The response body is a JSON object with the following schema:

``` json
{
  "token": "string"
}

 ```

- token (string): The authentication token obtained upon successful login.
### Method: POST
>```
>undefined
>```
### Body (**raw**)

```json
{
    "email": "anthony2@gmail.com",
    "password": "12345678Aa!"
}
```

### Response: 404
```json
{
    "date": "2025-01-25T08:04:10.986+00:00",
    "message": "El usuario con el correo moroccoire.dev@gmail.com no existe",
    "details": "El usuario no existe"
}
```

### Response: 400
```json
{
    "date": "2025-01-25T08:04:54.593+00:00",
    "message": "La contraseña es incorrecta",
    "details": null
}
```

### Response: 400
```json
{
    "date": "2025-01-25T08:05:20.541+00:00",
    "message": "El cuerpo de la solicitud no es válido o está mal formado.",
    "details": null
}
```

### Response: 400
```json
{
    "password": "La contraseña debe tener entre 8 y 20 caracteres, al menos una letra mayúscula, una letra minúscula, un dígito, y sólo caracteres alfanuméricos o los especiales: - _ . : ! @ # $ % ^ & *",
    "email": "Ingrese un email valido"
}
```

### Response: 200
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImFudGhvbnkxQGdtYWlsLmNvbSIsInVzZXJuYW1lIjoiYW50aG9ueTEiLCJzdWIiOiJhbnRob255MSIsImlhdCI6MTczNzc5MjQ1NCwiZXhwIjoxNzM3ODc4ODU0fQ.cQd8KFuTHewWdSi2vNQ8qmA4hm6Eq4zFzF3c6QA6RgY",
    "username": "anthony1",
    "email": "anthony1@gmail.com"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: REGISTER
### Register User

This endpoint allows users to register with the application.

#### Request Body

- `username` (string) : The username of the user.
    
- `password` (string) : The password for the user account.
    
- `email` (string) : The email address of the user.
    

#### Response

The response for this request is a JSON object with the following schema:

``` json
{
    "userId": "string",
    "username": "string",
    "email": "string"
}

 ```
### Method: POST
>```
>undefined
>```
### Body (**raw**)

```json
{
    "username": "anthony2",
    "password": "12345678Aa!",
    "email": "anthony2@gmail.com"
}
```

### Response: 400
```json
{
    "password": "La contraseña debe tener entre 8 y 20 caracteres, al menos una letra mayúscula, una letra minúscula, un dígito, y sólo caracteres alfanuméricos o los especiales: - _ . : ! @ # $ % ^ & *",
    "email": "¡El email ingresado no es válido!",
    "username": "El nombre de usuario debe tener entre 4 y 16 caracteres, y solo se permiten los caracteres especiales: - _ . : ! @ # $ % ^ & * son aceptados!"
}
```

### Response: 200
```json
{
    "token": "eyJhbGciOiJIUzI1NiJ9.eyJlbWFpbCI6ImFudGhvbnkxQGdtYWlsLmNvbSIsInVzZXJuYW1lIjoiYW50aG9ueTEiLCJzdWIiOiJhbnRob255MSIsImlhdCI6MTczNzc5MTk5NSwiZXhwIjoxNzM3ODc4Mzk1fQ.bOuVLxeEf0ZpS5vcR9sV-m31HivPUv_F3me6TRS2Y_s",
    "username": "anthony1",
    "email": "anthony1@gmail.com"
}
```

### Response: 400
```json
{
    "date": "2025-01-25T08:11:57.134+00:00",
    "message": "El cuerpo de la solicitud no es válido o está mal formado.",
    "details": null
}
```

### Response: 409
```json
{
    "date": "2025-01-25T08:13:34.666+00:00",
    "message": "El usuario anthony2 o anthony2@gmail.com ya fueron registrados",
    "details": "El nombre de usuario o correo ya fueron registrados"
}
```

### Response: 409
```json
{
    "date": "2025-01-25T08:14:44.261+00:00",
    "message": "El usuario anthony2 o anthony2@gmail.com ya fueron registrados",
    "details": "El nombre de usuario o correo ya fueron registrados"
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
_________________________________________________
Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)
# Songs
Endpoints for songs

## End-point: GET ALL GENRES
### Get Genre

This endpoint retrieves a list of genres.

#### Request

- Method: GET
    
- Endpoint: {{url}}/api/genre/get
    

#### Response

The response for this request is a JSON object with the following schema:

``` json
{
  "content": [
    {
      "name": "string",
      "description": "string"
    }
  ],
  "pagination": null
}

 ```

The `content` array contains objects with `name` and `description` properties, representing the genres retrieved. The `pagination` property is null, indicating that there is no pagination information included in the response.
### Method: GET
>```
>{{url}}/api/genre/get
>```
### Headers

|Content-Type|Value|
|---|---|
|genreName|pop|


### Query Params

|Param|value|
|---|---|
|||


### 🔑 Authentication bearer

|Param|value|Type|
|---|---|---|
|token|{{token}}|


### Response: 200
```json
{
    "content": [
        {
            "name": "rock",
            "description": "Música rock"
        },
        {
            "name": "pop",
            "description": "Música pop"
        },
        {
            "name": "videojuego",
            "description": "Música indie de videojuegos"
        },
        {
            "name": "eurodance",
            "description": "Subgénero de la música electrónica"
        }
    ],
    "pagination": null
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: GET SONGS BY GENRE
### Get Songs by Genre

This endpoint retrieves a list of songs based on the specified genre.

#### Request

- Method: GET
    
- URL: `{{url}}/api/genre/get/songs`
    
- Query Parameters:
    
    - `genreName` (string, required): The name of the genre for which songs are to be retrieved.
        

#### Response

The response will be a JSON object with the following schema:

``` json
{
  "type": "object",
  "properties": {
    "content": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "name": { "type": "string" },
          "coverPicture": { "type": "string" },
          "sourceUrl": { "type": "string" },
          "artists": {
            "type": "array",
            "items": {
              "type": "object",
              "properties": {
                "name": { "type": "string" },
                "lastname": { "type": "string" },
                "coverPicture": { "type": "string" },
                "country": { "type": "string" },
                "bio": { "type": ["string", "null"] }
              }
            }
          },
          "durationSeconds": { "type": "integer" },
          "likes": { "type": "integer" },
          "public": { "type": "boolean" }
        }
      }
    },
    "pagination": {
      "type": "object",
      "properties": {
        "pageNumber": { "type": "integer" },
        "pageSize": { "type": "integer" },
        "totalElements": { "type": "integer" },
        "last": { "type": "boolean" }
      }
    }
  }
}

 ```
### Method: GET
>```
>{{url}}/api/genre/get/songs?genreName=rock
>```
### Query Params

|Param|value|
|---|---|
|genreName|rock|


### 🔑 Authentication bearer

|Param|value|Type|
|---|---|---|
|token|{{token}}|


### Response: 200
```json
{
    "content": [
        {
            "name": "Judas",
            "coverPicture": "https://console.minio.icu/coverpicture/ccpladyGaga.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=1b14993294bc089b31bc844f58f34fecf667637a3a6b3d0a2878b5aff285fc3d",
            "sourceUrl": "https://console.minio.icu/audio/Lady%20Gaga%20-%20Judas%20%28Audio%29.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=525c463428097ddbb76d3a1c9c41cdf970feb227c35b8b0453630df5b31afff4",
            "artists": [
                {
                    "name": "Lady",
                    "lastname": "Gaga",
                    "coverPicture": "https://console.minio.icu/artist/acpLadyGaga.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=14cf919dc6c4b85b35934cbbeeca9656f424c8879fb19fae8c494772c1834fcc",
                    "country": "CANADA",
                    "bio": null
                }
            ],
            "durationSeconds": 249,
            "likes": 0,
            "public": true
        }
    ],
    "pagination": {
        "pageNumber": 0,
        "pageSize": 10,
        "totalElements": 1,
        "last": true
    }
}
```

### Response: 200
```json
{
    "content": [
        {
            "name": "Paint It, Black",
            "coverPicture": "https://console.minio.icu/coverpicture/ccpTheRollingStonesPaintedBlack.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=4443283861b9c40e77c507417921c7b95bb35d3b1346fef7d333ca97b72c1e2c",
            "sourceUrl": "https://console.minio.icu/audio/The%20Rolling%20Stones%20-%20Paint%20It%2C%20Black.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=612b5b6cb11f79ac67f23a0239b0b77a919ec2c6aecf02b32fbd1dc53a08a032",
            "artists": [
                {
                    "name": "The Rolling Stones",
                    "lastname": "",
                    "coverPicture": "https://console.minio.icu/artist/acpTheRollingStones.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=becefef934e262753c1e35f59ef27139667b61112c8145feb18a70aa3302ff7a",
                    "country": "CANADA",
                    "bio": null
                }
            ],
            "durationSeconds": 226,
            "likes": 0,
            "public": true
        }
    ],
    "pagination": {
        "pageNumber": 0,
        "pageSize": 10,
        "totalElements": 1,
        "last": true
    }
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: GET ALL SONGS
# Get Song Details

This endpoint retrieves the details of a song.

## Request

- Method: `GET`
    
- Endpoint: `{{url}}/api/song/get`
    

## Response

The response for this request follows the below JSON schema:

``` json
{
    "content": [
        {
            "name": "string",
            "coverPicture": "string",
            "sourceUrl": "string",
            "artists": [
                {
                    "name": "string",
                    "lastname": "string",
                    "coverPicture": "string",
                    "country": "string",
                    "bio": "string"
                }
            ],
            "durationSeconds": 0,
            "likes": 0,
            "public": true
        }
    ],
    "pagination": null
}

 ```
### Method: GET
>```
>undefined
>```
### 🔑 Authentication bearer

|Param|value|Type|
|---|---|---|
|token|{{token}}|


### Response: 200
```json
{
    "content": [
        {
            "name": "Desire Dream",
            "coverPicture": "https://console.minio.icu/coverpicture/ccpDesireDreamTH.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T015023Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=019568dc3f102950545cdb1e3ea3746ced2d9d56d06fbb21ffd744056d7aa9cb",
            "sourceUrl": "https://console.minio.icu/audio/Touhou-Desire%20Dream.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T015023Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=c0db99a591c77e52c51a3af9e2578b639ded77519ac4893404d068fff64a81b6",
            "artists": [
                {
                    "name": "Touhou Project",
                    "lastname": "",
                    "coverPicture": "https://console.minio.icu/artist/acpTouhouProject.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T015023Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=09a72a584627471c92317dc4c712cc55d1e0482a840296994023ca6d3f5793fa",
                    "country": "CANADA",
                    "bio": null
                }
            ],
            "durationSeconds": 174,
            "likes": 0,
            "public": true
        },
        {
            "name": "Judas",
            "coverPicture": "https://console.minio.icu/coverpicture/ccpladyGaga.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=1b14993294bc089b31bc844f58f34fecf667637a3a6b3d0a2878b5aff285fc3d",
            "sourceUrl": "https://console.minio.icu/audio/Lady%20Gaga%20-%20Judas%20%28Audio%29.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=525c463428097ddbb76d3a1c9c41cdf970feb227c35b8b0453630df5b31afff4",
            "artists": [
                {
                    "name": "Lady",
                    "lastname": "Gaga",
                    "coverPicture": "https://console.minio.icu/artist/acpLadyGaga.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=14cf919dc6c4b85b35934cbbeeca9656f424c8879fb19fae8c494772c1834fcc",
                    "country": "CANADA",
                    "bio": null
                }
            ],
            "durationSeconds": 249,
            "likes": 0,
            "public": true
        },
        {
            "name": "Paint It, Black",
            "coverPicture": "https://console.minio.icu/coverpicture/ccpTheRollingStonesPaintedBlack.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=4443283861b9c40e77c507417921c7b95bb35d3b1346fef7d333ca97b72c1e2c",
            "sourceUrl": "https://console.minio.icu/audio/The%20Rolling%20Stones%20-%20Paint%20It%2C%20Black.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=612b5b6cb11f79ac67f23a0239b0b77a919ec2c6aecf02b32fbd1dc53a08a032",
            "artists": [
                {
                    "name": "The Rolling Stones",
                    "lastname": "",
                    "coverPicture": "https://console.minio.icu/artist/acpTheRollingStones.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=becefef934e262753c1e35f59ef27139667b61112c8145feb18a70aa3302ff7a",
                    "country": "CANADA",
                    "bio": null
                }
            ],
            "durationSeconds": 226,
            "likes": 0,
            "public": true
        },
        {
            "name": "The Riddle",
            "coverPicture": "https://console.minio.icu/coverpicture/ccpTheRiddle.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T015023Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=77d8f1ab69f2475a7bec27bd28a9fb100b49eb4c163486d3f303a5cdb0e34f5b",
            "sourceUrl": "https://console.minio.icu/audio/Gigi%20D%27Agostino%20-%20The%20Riddle.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T015023Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=a5067cbac0198ea4d23c3391a6cd887c41bd3b3d8ac487f72d5cf2e608c667fc",
            "artists": [
                {
                    "name": "Gigi",
                    "lastname": "D'Agostino",
                    "coverPicture": "https://console.minio.icu/artist/acpGigidAgostino.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T015023Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=491dd90dfb74cd443b8985375548a5595931910772dc2ab1b885f0d707b28f0d",
                    "country": "CANADA",
                    "bio": null
                }
            ],
            "durationSeconds": 207,
            "likes": 0,
            "public": true
        }
    ],
    "pagination": null
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: GET SONGS BY NAME
This endpoint makes an HTTP GET request to retrieve song details based on the provided name parameter. The response will be in JSON format and will include an array of content containing song details such as name, cover picture, source URL, artists, duration, likes, and public status. Additionally, the response will include pagination information with details like the page number, page size, total elements, and whether it is the last page.

``` json
{
  "type": "object",
  "properties": {
    "content": {
      "type": "array",
      "items": {
        "type": "object",
        "properties": {
          "name": { "type": "string" },
          "coverPicture": { "type": "string" },
          "sourceUrl": { "type": "string" },
          "artists": {
            "type": "array",
            "items": {
              "type": "object",
              "properties": {
                "name": { "type": "string" },
                "lastname": { "type": "string" },
                "coverPicture": { "type": "string" },
                "country": { "type": "string" },
                "bio": { "type": ["string", "null"] }
              }
            }
          },
          "durationSeconds": { "type": "integer" },
          "likes": { "type": "integer" },
          "public": { "type": "boolean" }
        }
      }
    },
    "pagination": {
      "type": "object",
      "properties": {
        "pageNumber": { "type": "integer" },
        "pageSize": { "type": "integer" },
        "totalElements": { "type": "integer" },
        "last": { "type": "boolean" }
      }
    }
  }
}

 ```
### Method: GET
>```
>{{url}}/api/song/get/name?name=ju
>```
### Query Params

|Param|value|
|---|---|
|name|ju|


### 🔑 Authentication bearer

|Param|value|Type|
|---|---|---|
|token|{{token}}|


### Response: 200
```json
{
    "content": [
        {
            "name": "Judas",
            "coverPicture": "https://console.minio.icu/coverpicture/ccpladyGaga.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=1b14993294bc089b31bc844f58f34fecf667637a3a6b3d0a2878b5aff285fc3d",
            "sourceUrl": "https://console.minio.icu/audio/Lady%20Gaga%20-%20Judas%20%28Audio%29.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=525c463428097ddbb76d3a1c9c41cdf970feb227c35b8b0453630df5b31afff4",
            "artists": [
                {
                    "name": "Lady",
                    "lastname": "Gaga",
                    "coverPicture": "https://console.minio.icu/artist/acpLadyGaga.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=14cf919dc6c4b85b35934cbbeeca9656f424c8879fb19fae8c494772c1834fcc",
                    "country": "CANADA",
                    "bio": null
                }
            ],
            "durationSeconds": 249,
            "likes": 0,
            "public": true
        }
    ],
    "pagination": {
        "pageNumber": 0,
        "pageSize": 10,
        "totalElements": 1,
        "last": true
    }
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃

## End-point: GET SONGS BY ARTIST
### Get Artist's Songs

This endpoint retrieves songs by a specific artist.

#### Request

- Method: GET
    
- URL: `{{url}}/api/song/get/artist`
    
- Query Parameters:
    
    - `artistName` (string, required): The name of the artist.
        

#### Response

The response for this request is a JSON object with the following schema:

``` json
{
  "content": [
    {
      "name": "",
      "coverPicture": "",
      "sourceUrl": "",
      "artists": [
        {
          "name": "",
          "lastname": "",
          "coverPicture": "",
          "country": "",
          "bio": null
        }
      ],
      "durationSeconds": 0,
      "likes": 0,
      "public": true
    }
  ],
  "pagination": {
    "pageNumber": 0,
    "pageSize": 0,
    "totalElements": 0,
    "last": true
  }
}

 ```

The `content` array contains information about the songs, including name, cover picture, source URL, artists, duration, likes, and public status. The `pagination` object provides information about the pagination of the results.
### Method: GET
>```
>{{url}}/api/song/get/artist?artistName=ling
>```
### Query Params

|Param|value|
|---|---|
|artistName|ling|


### 🔑 Authentication bearer

|Param|value|Type|
|---|---|---|
|token|{{token}}|


### Response: 200
```json
{
    "content": [
        {
            "name": "Paint It, Black",
            "coverPicture": "https://console.minio.icu/coverpicture/ccpTheRollingStonesPaintedBlack.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=4443283861b9c40e77c507417921c7b95bb35d3b1346fef7d333ca97b72c1e2c",
            "sourceUrl": "https://console.minio.icu/audio/The%20Rolling%20Stones%20-%20Paint%20It%2C%20Black.mp3?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=612b5b6cb11f79ac67f23a0239b0b77a919ec2c6aecf02b32fbd1dc53a08a032",
            "artists": [
                {
                    "name": "The Rolling Stones",
                    "lastname": "",
                    "coverPicture": "https://console.minio.icu/artist/acpTheRollingStones.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=becefef934e262753c1e35f59ef27139667b61112c8145feb18a70aa3302ff7a",
                    "country": "CANADA",
                    "bio": null
                }
            ],
            "durationSeconds": 226,
            "likes": 0,
            "public": true
        }
    ],
    "pagination": {
        "pageNumber": 0,
        "pageSize": 10,
        "totalElements": 1,
        "last": true
    }
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
_________________________________________________
Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)
# Artists
Endpoint for artists

## End-point: GET ALL ARTIST
### API Request Description

This endpoint makes an HTTP GET request to retrieve artist information.

### Response

The response for this request follows the JSON schema below:

``` json
{
  "content": [
    {
      "name": "",
      "lastname": "",
      "coverPicture": "",
      "country": "",
      "bio": null
    }
  ],
  "pagination": {
    "pageNumber": 0,
    "pageSize": 0,
    "totalElements": 0,
    "last": true
  }
}

 ```
### Method: GET
>```
>undefined
>```
### 🔑 Authentication bearer

|Param|value|Type|
|---|---|---|
|token|{{token}}|


### Response: 200
```json
{
    "content": [
        {
            "name": "Gigi",
            "lastname": "D'Agostino",
            "coverPicture": "https://console.minio.icu/artist/acpGigidAgostino.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T015023Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=491dd90dfb74cd443b8985375548a5595931910772dc2ab1b885f0d707b28f0d",
            "country": "CANADA",
            "bio": null
        },
        {
            "name": "Lady",
            "lastname": "Gaga",
            "coverPicture": "https://console.minio.icu/artist/acpLadyGaga.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014815Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=14cf919dc6c4b85b35934cbbeeca9656f424c8879fb19fae8c494772c1834fcc",
            "country": "CANADA",
            "bio": null
        },
        {
            "name": "The Rolling Stones",
            "lastname": "",
            "coverPicture": "https://console.minio.icu/artist/acpTheRollingStones.jpeg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T014900Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=becefef934e262753c1e35f59ef27139667b61112c8145feb18a70aa3302ff7a",
            "country": "CANADA",
            "bio": null
        },
        {
            "name": "Touhou Project",
            "lastname": "",
            "coverPicture": "https://console.minio.icu/artist/acpTouhouProject.jpg?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=minioadmin%2F20250207%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20250207T015023Z&X-Amz-Expires=240&X-Amz-SignedHeaders=host&X-Amz-Signature=09a72a584627471c92317dc4c712cc55d1e0482a840296994023ca6d3f5793fa",
            "country": "CANADA",
            "bio": null
        }
    ],
    "pagination": {
        "pageNumber": 0,
        "pageSize": 10,
        "totalElements": 4,
        "last": true
    }
}
```


⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃ ⁃
_________________________________________________
Powered By: [postman-to-markdown](https://github.com/bautistaj/postman-to-markdown/)
