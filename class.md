# クラス・ファイル一覧

※ /で区切ってあるのはフォルダの階層を表しています。例えば、`hoge/foo`の場合はhogeフォルダの中にfooがある  
※ 途中で変更になる可能性もありますが許してください＞＜

## ポイント地点登録画面(Point Register)  
Activity: spot/activity/SpotActivity.kt  
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
Activity: spot/activity/SpotActivity.kt  
Fragment・画面: spot/select/ui/ListFragment.kt  
Row Item: spot/select/ui/ListRowItem.kt  
ViewModel: spot/select/ui/ListViewModel.kt  
model: spot/model/ListData.kt  

## レーダー画面
Activity: spot/activity/SpotActivity.kt  
Fragment・画面: spot/select/radar/ui/RadarFragment.kt  
Popup: spot/select/radar/ui/RadarPopup.kt  
ViewModel: spot/select/radar/ui/RadarViewModel.kt  
model: spot/model/SpotData.kt    

## Navigate画面
Activity: spot/activity/SpotActivity.kt  
Fragment・画面: spot/navigate/ui/RadarFragment.kt  
ViewModel: spot/navigate/ui/RadarViewModel.kt  
model: spot/model/SpotData.kt  

## search画面
Activity: spot/activity/SpotActivity.kt  
Fragment・画面: spot/select/search/ui/RadarFragment.kt  
ViewModel: spot/select/search/ui/RadarViewModel.kt  
model: spot/model/HistoryData.kt, spot/model/RegisterPointData.kt, MeetingPlaceData.kt  

## Util
SpotType.kt(enum)  
