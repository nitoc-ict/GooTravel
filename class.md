# クラス・ファイル一覧

※ /で区切ってあるのはフォルダの階層を表しています。例えば、`hoge/foo`の場合はhogeフォルダの中にfooがある  
※ 途中で変更になる可能性もありますが許してください＞＜

## ポイント地点登録画面(Point Register)  
Activity: spot/register/ui/RegisterActivity.kt  
Fragment・画面: spot/register/ui/RegisterFragment.kt  
ViewModel: spot/register/ui/RegisterViewModel.kt  
model: spot/model/RegisterPointData.kt  

## アラート周り(Alert、Wi-Fi auto Auth)  
### 災害
Alert(災害速報): disaster/notification/ui/NotificationAlertDialog.kt  
model: disaster/model/NotificationModel.kt  
### Wi-Fi
Dialog: wifi/connect/ui/ConnectDialog.kt  
model: wifi/connect/mode/DialogData.kt  

## マニュアル表示画面(Manual)　　
Activity: disaster/manual/ui/ManualActivity.kt  
Fragment・画面: disaster/manual/ui/ManualFragment.kt  
ViewModel: disaster/manual/ui/ManualViewModel.kt  
model: disaster/model/ManualData.kt  

## 近くの地点リスト表示(List)  
Activity: spot/select/ui/ListActivity.kt  
Fragment・画面: spot/select/ui/ListFragment.kt  
Row Item: spot/select/ui/ListRowItem.kt  
ViewModel: spot/select/ui/ListViewModel.kt  
model: spot/model/ListData.kt  

## レーダー画面
Activity: spot/select/radar/ui/RadarActivity.kt  
Fragment・画面: spot/select/radar/ui/RadarFragment.kt  
Popup: spot/select/radar/ui/RadarPopup.kt
ViewModel: spot/select/radar/ui/RadarViewModel.kt  
model: spot/model/SpotData.kt  


