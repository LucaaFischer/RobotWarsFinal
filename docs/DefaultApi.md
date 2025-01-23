# DefaultApi

All URIs are relative to *https://82rvkz5o22.execute-api.eu-central-1.amazonaws.com/prod/*

Method | HTTP request | Description
------------- | ------------- | -------------
[**apiGamesGameIdGet**](DefaultApi.md#apiGamesGameIdGet) | **GET** /api/games/game/{id} | Bestimmtes Spiel
[**apiGamesGameIdJoinPost**](DefaultApi.md#apiGamesGameIdJoinPost) | **POST** /api/games/game/{id}/join | Spiel beitreten
[**apiGamesGameIdMoveGet**](DefaultApi.md#apiGamesGameIdMoveGet) | **GET** /api/games/game/{id}/move | Alle Bewegungen
[**apiGamesGameIdMoveMoveIdAfterGet**](DefaultApi.md#apiGamesGameIdMoveMoveIdAfterGet) | **GET** /api/games/game/{id}/move/{moveId}/after | Alle Bewegungen
[**apiGamesGameIdMovePlayerPlayerIdPost**](DefaultApi.md#apiGamesGameIdMovePlayerPlayerIdPost) | **POST** /api/games/game/{id}/move/player/{playerId} | Einen Zug machen
[**apiGamesGamePost**](DefaultApi.md#apiGamesGamePost) | **POST** /api/games/game | Einen neues Spiel erstellen
[**apiGamesGet**](DefaultApi.md#apiGamesGet) | **GET** /api/games | Liste von Spielen
[**apiMapsGet**](DefaultApi.md#apiMapsGet) | **GET** /api/maps | Karten
[**apiMapsMapIdGet**](DefaultApi.md#apiMapsMapIdGet) | **GET** /api/maps/map/{id} | Bestimmte Karte
[**apiRobotsGet**](DefaultApi.md#apiRobotsGet) | **GET** /api/robots | Liste von Robotern
[**apiRobotsRobotIdGet**](DefaultApi.md#apiRobotsRobotIdGet) | **GET** /api/robots/robot/{id} | Bestimmter Roboter
[**apiRobotsRobotPost**](DefaultApi.md#apiRobotsRobotPost) | **POST** /api/robots/robot | Einen neuen Roboter erstellen

<a name="apiGamesGameIdGet"></a>
# **apiGamesGameIdGet**
> Game apiGamesGameIdGet(id)

Bestimmtes Spiel

Liefert ein Spiel mit der ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | Die ID des Spiel.
try {
    Game result = apiInstance.apiGamesGameIdGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiGamesGameIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Die ID des Spiel. |

### Return type

[**Game**](Game.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiGamesGameIdJoinPost"></a>
# **apiGamesGameIdJoinPost**
> JoinGameResponse apiGamesGameIdJoinPost(body, id)

Spiel beitreten

Einen bestehenden Spiel beitreten

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
JoinGame body = new JoinGame(); // JoinGame | 
String id = "id_example"; // String | Die ID des Spiels.
try {
    JoinGameResponse result = apiInstance.apiGamesGameIdJoinPost(body, id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiGamesGameIdJoinPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**JoinGame**](JoinGame.md)|  |
 **id** | **String**| Die ID des Spiels. |

### Return type

[**JoinGameResponse**](JoinGameResponse.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="apiGamesGameIdMoveGet"></a>
# **apiGamesGameIdMoveGet**
> List&lt;Move&gt; apiGamesGameIdMoveGet(id)

Alle Bewegungen

Liefert eine Liste aller Bewegungen im einem bestimmten Spiel.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | Die ID des Spiels.
try {
    List<Move> result = apiInstance.apiGamesGameIdMoveGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiGamesGameIdMoveGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Die ID des Spiels. |

### Return type

[**List&lt;Move&gt;**](Move.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiGamesGameIdMoveMoveIdAfterGet"></a>
# **apiGamesGameIdMoveMoveIdAfterGet**
> List&lt;Move&gt; apiGamesGameIdMoveMoveIdAfterGet(id, moveId)

Alle Bewegungen

Liefert eine Liste aller Bewegungen nach der Bewegung die in der MoveID beschreiben ist, im einem bestimmten Spiel.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | Die ID des Spiels.
String moveId = "moveId_example"; // String | Die ID des Spiels.
try {
    List<Move> result = apiInstance.apiGamesGameIdMoveMoveIdAfterGet(id, moveId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiGamesGameIdMoveMoveIdAfterGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Die ID des Spiels. |
 **moveId** | **String**| Die ID des Spiels. |

### Return type

[**List&lt;Move&gt;**](Move.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiGamesGameIdMovePlayerPlayerIdPost"></a>
# **apiGamesGameIdMovePlayerPlayerIdPost**
> Move apiGamesGameIdMovePlayerPlayerIdPost(body, id, playerId)

Einen Zug machen

Macht einen zug.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
NewMove body = new NewMove(); // NewMove | 
String id = "id_example"; // String | Die ID des Spiels.
String playerId = "playerId_example"; // String | Die ID des Spielers.
try {
    Move result = apiInstance.apiGamesGameIdMovePlayerPlayerIdPost(body, id, playerId);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiGamesGameIdMovePlayerPlayerIdPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**NewMove**](NewMove.md)|  |
 **id** | **String**| Die ID des Spiels. |
 **playerId** | **String**| Die ID des Spielers. |

### Return type

[**Move**](Move.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="apiGamesGamePost"></a>
# **apiGamesGamePost**
> Game apiGamesGamePost(body)

Einen neues Spiel erstellen

Erstellt ein neues Spielt.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
NewGame body = new NewGame(); // NewGame | 
try {
    Game result = apiInstance.apiGamesGamePost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiGamesGamePost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**NewGame**](NewGame.md)|  |

### Return type

[**Game**](Game.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

<a name="apiGamesGet"></a>
# **apiGamesGet**
> List&lt;Game&gt; apiGamesGet()

Liste von Spielen

Liefert von allen Spielen

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<Game> result = apiInstance.apiGamesGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiGamesGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Game&gt;**](Game.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiMapsGet"></a>
# **apiMapsGet**
> List&lt;java.util.Map&gt; apiMapsGet()

Karten

Liefert alle vorhandenen Karten

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<java.util.Map> result = apiInstance.apiMapsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiMapsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;java.util.Map&gt;**](java.util.Map.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiMapsMapIdGet"></a>
# **apiMapsMapIdGet**
> java.util.Map apiMapsMapIdGet(id)

Bestimmte Karte

Liefert alle vorhandenen Karten

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | Die ID der Karte.
try {
    java.util.Map result = apiInstance.apiMapsMapIdGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiMapsMapIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Die ID der Karte. |

### Return type

[**java.util.Map**](java.util.Map.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiRobotsGet"></a>
# **apiRobotsGet**
> List&lt;Robot&gt; apiRobotsGet()

Liste von Robotern

Liefert eine liste von allen Robotern

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
try {
    List<Robot> result = apiInstance.apiRobotsGet();
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiRobotsGet");
    e.printStackTrace();
}
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**List&lt;Robot&gt;**](Robot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiRobotsRobotIdGet"></a>
# **apiRobotsRobotIdGet**
> List&lt;Robot&gt; apiRobotsRobotIdGet(id)

Bestimmter Roboter

Liefert einen Roboter mit der ID

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
String id = "id_example"; // String | Die ID des Roboters.
try {
    List<Robot> result = apiInstance.apiRobotsRobotIdGet(id);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiRobotsRobotIdGet");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **id** | **String**| Die ID des Roboters. |

### Return type

[**List&lt;Robot&gt;**](Robot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

<a name="apiRobotsRobotPost"></a>
# **apiRobotsRobotPost**
> Robot apiRobotsRobotPost(body)

Einen neuen Roboter erstellen

Erstellt einen neuen Roboter mit den bereitgestellten Daten.

### Example
```java
// Import classes:
//import io.swagger.client.ApiException;
//import io.swagger.client.api.DefaultApi;


DefaultApi apiInstance = new DefaultApi();
NewRobot body = new NewRobot(); // NewRobot | 
try {
    Robot result = apiInstance.apiRobotsRobotPost(body);
    System.out.println(result);
} catch (ApiException e) {
    System.err.println("Exception when calling DefaultApi#apiRobotsRobotPost");
    e.printStackTrace();
}
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **body** | [**NewRobot**](NewRobot.md)|  |

### Return type

[**Robot**](Robot.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: application/json

