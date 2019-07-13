# GooTravel

## 環境
Android Studio 3.4.2  
Kotlin 1.3.41  
minSdkVersion 22  

## 設計方針
MVVM(予定)  
### MVVMがどんなのか貼る
### サンプル貼る

## GitHub運営方針
Git Flowをベースにしたものを仕様  
基本、ブランチは以下の種類がありそれを利用する  
- master
- develop
- feature/hoge

### master
完成系やある程度機能ができた時にマージされる  
教授や他に見せれるバージョンのアプリがいつでも使えるようにしておく  

### develop
開発中のアプリが置かれる  
ある機能が完成した時などにマージされる  
見せられるかもしれないけどバグを含んでいるかもしれない時  

### feature/hoge
ある機能を作成中のアプリが置かれる  
基本的に、このブランチをdevelopから生やして開発を進めていく  
hogeの部分は今開発中の機能名が来る(feature/searchなど)  
一番最初のcommitはこのブランチでは何をするかがメッセージとして書かれた空コミット   
`git commit --allow-empty -m "メッセージ(searchなど)"`

### Pull Request(PR,プルリク)
feature/hogeブランチを作成して空コミットを作成した段階でpush、プルリクの作成をする(ただしDraft状態)  
作業を終えたらDraft状態を外してレビュー可能状態にする、レビュワーはmito+誰かをつける  
LGTM(Look Good To Me)を貰ったらGitHub上でマージする  
LGTMをもらった前でも後でもレビュワーになっていない人でも気になったところはお互いに勉強の機会になるのでなんでも聞くこと！
