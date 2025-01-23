# Game

## Properties
Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **String** | Einzigartige Id des Spiels | 
**map** | **String** | Map Id | 
**player** | [**List&lt;PlayerRobot&gt;**](PlayerRobot.md) |  |  [optional]
**moves** | [**List&lt;Move&gt;**](Move.md) |  | 
**status** | [**StatusEnum**](#StatusEnum) | STARTED, INITIAL, END |  [optional]

<a name="StatusEnum"></a>
## Enum: StatusEnum
Name | Value
---- | -----
STARTED | &quot;STARTED&quot;
INITIAL | &quot;INITIAL&quot;
END | &quot;END&quot;
