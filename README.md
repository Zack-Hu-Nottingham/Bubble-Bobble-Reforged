# 	AE2DMS-CW-20215538

"Zixiang Hu" 20215538 scyzh6@nottingham.edu.cn

>word count: 498

### Refactor:

- Replace swing with Javafx.
- Split clumsy class to achieve single responsibility. Split InteractableWorld.java to [GameScene.java](BubbleBobble/src/main/java/com/ae2dms/model/scene/GameScene.java)(model) and [GameSceneController.java](BubbleBobble/src/main/java/com/ae2dms/controller/gameScene/GameSceneController.java)(controller). Where [GameScene.java](BubbleBobble/src/main/java/com/ae2dms/model/scene/GameScene.java) encapsulate all the sub-models exist in the game like hero, enemy. It also provides public methods like [getGameScenePainter().paintComponent()](BubbleBobble/src/main/java/com/ae2dms/controller/gameScene/GameSceneController.java) for controller to invoke. 

- Apply MVC pattern. Categorize the files into three main package: model, controller and util, and put the [view](BubbleBobble/src/main/resources/view_fxml)(fxml) part in resources folder. Split the game's view into three main part: menu, gameScene & gameOverScene, each part have its own FXML and controller. 
- Extract multi-level abstraction. Extract abstract class like [GameObject.java](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/GameObject.java), [WallObject.java](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/wall/WallObject/WallObject.java), [SpriteObject.java](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/sprite/SpriteObject.java). Other concrete class would extends these abstract class and get rid of duplicate codes.
- Encapsulate fields. Encapsulate crucial fields of game object with getter and setter, to have a better protection and encapsulation.



### Feature:

- Complicated setting page. Player could select theme, difficulty and volume. With different difficulty, the chance to shoot, speed and size of enemy would vary.
- Randomly dropped fruit with collect effects and sounds. When enemy killed, it would randomly drop a kind of fruit and collect it would pop up hint tells how much bonus it worth. 
- Game scene equipped with level hint, score hint, time hint, boss remaining life hint and hero charging status hint.
- Multi-level with final level's boss. The boss can withstand more shoots, and shoots a different kind of bubble.
- Animation between the switch of scene. Click subpage in menu, the subpage would gently slide from the bottom to the top. Click back button in game scene, the background would blur with the confirm page pop up. All these are implemented by nested FXML with nested controller.
- No actual buttons/checkBox/choiceBox used, all are simulated with imageView combined with animation and sounds.



### Design pattern:

- Singleton pattern: [GamePanel.java](BubbleBobble/src/main/java/com/ae2dms/GamePanel.java), the director of the game, would only be constructed once and its instance would be returned by [getInstance()](BubbleBobble/src/main/java/com/ae2dms/GamePanel.java#L31) as a handle.
- FlyWeight pattern: When creating [WallObjects](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/wall/wallObject), it gets wall's image from [WallImageFactory](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/wall/wallObject/WallImageFactory.java). Factory would check if the required image already exist, and if exist, return that image. It guarantees the image is created only once and shared by all the wallObjects, which would reduce the amount of duplicate memory.
- Template pattern: Abstract class [SpriteObject.java](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/sprite/SpriteObject.java) defines a template for all sprite object to extends. It implements method that is duplicate for all the sprite objects like [turnAround()](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/sprite/SpriteObject.java#L88). For method that differs, like [collideWithCeiling()](104) the implementation detail is down to each subclass.
- Factory pattern: [BossDropFruitFactory.java](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/sprite/fruit/fruitFactory/BossDropFruitFactory.java) and [EnemyDropFruitFactory.java](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/sprite/fruit/fruitFactory/EnemyDropFruitFactory.java) are two fruit factories that extends [FruitFactory.java](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/sprite/fruit/fruitFactory/FruitFactory.java). They create and return different kind of fruits according to requirements.
- Strategy pattern: Interface [CollideStrategy.java](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/wall/CollideStrategy/CollideStrategy.java) is implemented by [CollideWithWall](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/wall/collideStrategy/CollideWithWall.java), [CollideWithCeiling](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/wall/collideStrategy/CollideWithCeiling.java) & [CollideWithFloor](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/wall/collideStrategy/CollideWithFloor.java). Each [WallObject](BubbleBobble/src/main/java/com/ae2dms/model/gameObject/wall/wallObject/WallObject.java) contains a specific collide strategy, which decides how it collide with other object.



### Git work flow:

When an issue is raised a new branch would be created to handle . When solved, branch would be merge back.

Commit message follows AngularJS Git Commit Message Conventions.



### Test case:

**com.ae2dms.util**

| Test ID                  | Purpose of test | Input | Expect Outcome | Pass/Fail |
| ------------------------ | ---- | -------------- | ------- | -----|
| 1.1.1 - [GameRecorderTest](BubbleBobble/src/test/java/com/ae2dms/util/GameRecorderTest.java#L27) | test if returns highest score | <"Zixiang Hu",  200, 106> <"Bryan",  360, 60><"Yu Heng",  300, 54> | 360 | Pass |
| 1.1.2 - [GameRecorderTest](BubbleBobble/src/test/java/com/ae2dms/util/GameRecorderTest.java#L34) | test if reads records from file | <"Zixiang Hu",  200, 106> <"Bryan",  360, 60><"Yu Heng",  300, 54> | <"Bryan",  360, 60><"Yu Heng",  300, 54><"Zixiang Hu",  200, 106> | Pass |
| 1.1.3 - [GameRecorderTest](BubbleBobble/src/test/java/com/ae2dms/util/GameRecorderTest.java#L56) | test if sort the records with score | <"Zixiang Hu",  200, 106> <"Bryan",  360, 60><"Yu Heng",  300, 54> | <"Bryan",  360, 60><"Yu Heng",  300, 54><"Zixiang Hu",  200, 106> | Pass |
| 1.1.4 - [GameRecorderTest](BubbleBobble/src/test/java/com/ae2dms/util/GameRecorderTest.java#L78) | test if returns the name list | <"Zixiang Hu",  200, 106> <"Bryan",  360, 60><"Yu Heng",  300, 54> | <"Bryan", "Yu Heng", "Zixiang Hu"> | Pass |
| 1.1.5 - [GameRecorderTest](BubbleBobble/src/test/java/com/ae2dms/util/GameRecorderTest.java#L91) | test if it save records to file | <"Bub", 500, 50> | <"Bub", 500, 50> | Pass |
| 1.1.6 - [GameRecorderTest](BubbleBobble/src/test/java/com/ae2dms/util/GameRecorderTest.java#L103) | test if it returns score list | <"Zixiang Hu",  200, 106> <"Bryan",  360, 60><"Yu Heng",  300, 54><"Bub", 500, 50> | <500, 360, 300, 200> | Pass |
| 1.1.7 - [GameRecorderTest](BubbleBobble/src/test/java/com/ae2dms/util/GameRecorderTest.java#L115) | test if it returns time consumed | <"Zixiang Hu",  200, 106> <"Bryan",  360, 60><"Yu Heng",  300, 54><"Bub", 500, 50> | <50, 60, 54, 106> | Pass |
| 1.1.8 - [GameRecorderTest](BubbleBobble/src/test/java/com/ae2dms/util/GameRecorderTest.java#L127) | test if returns the number of records | <"Zixiang Hu",  200, 106> <"Bryan",  360, 60><"Yu Heng",  300, 54> | 3 | Pass |
| 1.2.1 - [GameTimerTest](BubbleBobble/src/test/java/com/ae2dms/util/GameTimerTest.java#L32) | test if parse time to correct format | 200, 0, 600 | "03:20", "00:00", "10:00" | Pass |
| 1.3.1 - [MapReaderTest](BubbleBobble/src/test/java/com/ae2dms/util/MapReaderTest.java#L32) | test if correctly read map | Map one | the arraylist of objects read from map is not empty | Pass |
| 1.3.2 - [MapReaderTest](BubbleBobble/src/test/java/com/ae2dms/util/MapReaderTest.java#L49) | test if correctly read map | Map two | the arraylist of objects read from map is not empty | Pass |
| 1.3.3 - [MapReaderTest](BubbleBobble/src/test/java/com/ae2dms/util/MapReaderTest.java#L68) | test if correctly read map | Map three | the arraylist of objects read from map is not empty | Pass |



**com.ae2dms.controller**

| Test ID                  | Purpose of test | Input | Expect Outcome | Pass/Fail |
| ------------------------ | ---- | -------------- | ------- | -----|
| 2.1.1 - [GameSceneControllerTest](BubbleBobble/src/test/java/com/ae2dms/controller/gameScene/GameSceneControllerTest.java#L38) | test if the level hint, charge status, current score correctly displayed | null | element correctly displayed | Pass |
| 2.2.1 - [MenuControllerTest](BubbleBobble/src/test/java/com/ae2dms/controller/menu/MenuControllerTest.java#L39) | test if buttons inside information page could be clicked and display animation | null | element correctly displayed | Pass |
| 2.2.1 - [MenuControllerTest](BubbleBobble/src/test/java/com/ae2dms/controller/menu/MenuControllerTest.java#L56) | test if buttons inside setting page could be clicked and correspondly modify the model  | null | element correctly displayed | Pass |
| 2.2.1 - [MenuControllerTest](BubbleBobble/src/test/java/com/ae2dms/controller/menu/MenuControllerTest.java#L101) | test if could click into highscore page and back from that page | null | element correctly displayed | Pass |



**com.ae2dms.GamePanelTest**

| Test ID                  | Purpose of test | Input | Expect Outcome | Pass/Fail |
| ------------------------ | ---- | -------------- | ------- | -----|
| 3.1 - [GamePanelTest](BubbleBobble/src/test/java/com/ae2dms/GamePanelTest.java#L36) | test if loadHelper loads fxml and set the fxml as scene's root | null | the scene is not null | Pass |
| 3.2 - [GamePanelTest](BubbleBobble/src/test/java/com/ae2dms/GamePanelTest.java#L43) | test if switch scene to menu | null | switch scene to menu | Pass |
| 3.3 - [GamePanelTest](BubbleBobble/src/test/java/com/ae2dms/GamePanelTest.java#L52) | test if switch scene to gameScene | null | switch scene to gameScene | Pass |
| 3.4 - [GamePanelTest](BubbleBobble/src/test/java/com/ae2dms/GamePanelTest.java#L60) | test if switch scene to gameOverScene | null | switch scene to gameOverScene | Pass |
| 3.5 - [GamePanelTest](BubbleBobble/src/test/java/com/ae2dms/GamePanelTest.java#L67) | test if switch scene to highScoreScene | null | switch scene to highScoreScene | Pass |
| 3.6 - [GamePanelTest](BubbleBobble/src/test/java/com/ae2dms/GamePanelTest.java#L74) | test if the bonus is incremented | 0 | 50 | Pass |



**com.ae2dms.model.gameObject.sprite**

| Test ID                  | Purpose of test | Input | Expect Outcome | Pass/Fail |
| ------------------------ | ---- | -------------- | ------- | -----|
| 4.1.1-[BossTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/BossTest.java#L31) | test if boss get attacked when collide with projectile | null | damage to boss increase 1 | Pass |
| 4.1.2-[BossTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/BossTest.java#L53) | when boss die, test if switch game status to win and if drops fruit | null | game status switch to win and drop the specified fruit | Pass |
| 4.1.3-[BossTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/BossTest.java#L70) | test if this method correctly return whether boss is bubbled | null | return true when boss is bubbled | Pass |
| 4.1.4-[BossTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/BossTest.java#L82) | test if boss shoots projectile                               | null | the array of boss projectile is not null | Pass |
| 4.2.1 - [BossDropFruitFactoryTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/fruit/fruitFactory/BossDropFruitFactoryTest.java#L39) | test if return the specified fruit | null | return the specified type of fruit | Pass |
| 4.3.1 - [EnemyDropFruitFactoryTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/fruit/fruitFactory/BossDropFruitFactoryTest.java#L39) | test if return the specified fruit | null | return the specified type of fruit | Pass |
| 4.4.1 - [BossProjectileTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/projectile/BossProjectileTest.java) | test if hero dies when boss's projectile collide with hero | null | hero die and game lose | Pass |
| 4.5.1 - [CollectEffectTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/prompt/CollectEffectTest.java#L29) | test if collect effect's inner time counter decrease with time pass by | null | with each call of update() counter minus 1 | Pass |
| 4.5.2 - [CollectEffectTest](BubbleBobble/src/test/java/com/ae2dms/model/gameObject/sprite/prompt/CollectEffectTest.java#L46) | test if collect effect's constructor returns collect effects | null | the returned collect effect is not null | Pass |
