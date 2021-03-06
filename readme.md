### What's this?
javaのWebアプリケーションフレームワーク
[tapestry](https://tapestry.apache.org/index.html) のサンプルプロジェクトです。

諸般の事情で`5.1.0.0`に準拠しています。

### 実行方法
`./gradlew appRun`

http://localhost:8080/tapestry5-practice にアクセスする

![alt](./readme/appRun.png)

##### 自動更新
ソースファイルを編集すると自動で更新されます。
更新されると以下のような例外が標準出力に表示されますが気にする必要はありません。

![alt](./readme/edit.png)

##### 停止方法
ターミナル上でエンターキーを押してください。
自動更新が一度でも行われていると以下のようなエラーが出ますが問題ありません。
ただし、8080ポートがすぐに開放されないことがあるので、
再度`./gradlew appRun`を実行する前にしばらく待ってください。

![alt](./readme/stop.png)

正規の方法以外でプロセスを止めると8080ポートが開放されないことがあります。
その場合は8080ポートを使用しているプロセスを直接止めてください。

### TODO
- [ ] page activation
- [ ] component event
    - [ ] handler
    - [ ] response
- [ ] components
    - [ ] control
        - [ ] if
        - [ ] loop
    - [ ] form
        - [ ] textfield
        - [ ] select
        - [ ] check
        - [ ] radio
        - [ ] textarea
    - [ ] block
    - [ ] zone
- [ ] persist