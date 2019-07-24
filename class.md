# クラス・ファイル一覧

※/で区切ってあるのはフォルダの階層を表しています。例えば、`hoge/foo`の場合はhogeフォルダの中にfooがある  

## ポイント地点登録画面(Point Register)  
Activity: spot/register/ui/RegisterActivity.kt  
Fragment・画面: spot/register/ui/RegisterFragment.kt  
ViewModel: spot/register/ui/RegisterViewModel.kt  
model: spot/model/RegisterPointData.kt  

## アラート周り(Alert、Wi-Fi auto Auth)  
Alert(災害速報): disaster/notification/ui/NotificationAlertDialog.kt  
model: disaster/model/NotificationModel.kt  

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
